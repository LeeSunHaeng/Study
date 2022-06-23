package com.example.favouritelist

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.location.LocationManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Looper
import android.provider.MediaStore
import android.util.Log
import android.widget.*
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.location.*
import java.io.FileOutputStream
import java.text.SimpleDateFormat

class insertActivity : AppCompatActivity() {
    private var locatioNManager:LocationManager? =null

    //Launcher
    lateinit var locationPermission: ActivityResultLauncher<Array<String>>

    // OnMapReady에서 위치 서비스가 GPS를 사용해서 위치를 확인
    lateinit var fusedLocationClient: FusedLocationProviderClient

    // OnMapReady에서 위치 값 요청에 대한 갱신 정보를 받는 변수
    lateinit var locationCallback : LocationCallback

    var latitude:Double = 0.0
    var longitude:Double = 0.0

    //storage 권한 처리에 필요한 변수
    val CAMERA = arrayOf(Manifest.permission.CAMERA)
    val STORAGE = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE)

    val CAMERA_CODE = 98
    val STORAGE_CODE = 99
    var imagePath:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insert)

        val latText = findViewById<TextView>(R.id.latView)
        val lonText = findViewById<TextView>(R.id.lonView)
        val imgText = findViewById<TextView>(R.id.imgView)
        val contentEditText = findViewById<EditText>(R.id.contentEditText)
        val saveBtn = findViewById<Button>(R.id.saveBtn)
        //카메라
        val camera = findViewById<Button>(R.id.cameraBtn)
        val dbHelper = DBHelper(this,"mydb.db",null,1)
        val database = dbHelper.writableDatabase

        camera.setOnClickListener {

            CallCamera()


            latText.text = latitude.toString()
            lonText.text = longitude.toString()

        }

        //사진 저장
/*        val picture = findViewById<Button>(R.id.picture)
        picture.setOnClickListener {
            GetAlbum()
        }*/

        saveBtn.setOnClickListener {
            imgText.text = imagePath
            val currentTime:Long = System.currentTimeMillis()
            val simpleDate = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
            val favourite = Favourite(0,imagePath,latitude,longitude,
                                        contentEditText.text.toString(),simpleDate.format(currentTime))
            dbHelper.insert(database,favourite)

            Toast.makeText(this,"추가되었습니다",Toast.LENGTH_SHORT).show()

            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)


        }

        //Launcher 생성
        locationPermission = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions() ){ results->
            if(results.all { it.value }){
            } else{ // 문제가 발생했을 때
                Toast.makeText(this, "권한 승인이 필요합니다", Toast.LENGTH_LONG).show()
            }
        }
        //Launcher 실행 -> 권한 승인을 요청, 2개의 권한을 승인받아야 하기 떄문에 배열을 이용
        locationPermission.launch(
            arrayOf(
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        )
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        updateLocation()

    }

    //카메라 권한, 저장소 권한
    //요청권한
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_CODE -> {
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"카메라 권한을 승인해 주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }
            STORAGE_CODE ->{
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this,"저장소 권한을 승인해 주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }

        }
    }
    //다른 권한들도 확인이 가능하도록
    fun checkPermission(permissions: Array<out String>,type:Int):Boolean{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for(permission in permissions){
                if(ContextCompat.checkSelfPermission(this,permission) != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this,permissions, type)
                    return false
                }
            }
        }
        return true
    }

    //카메라 촬영 - 권한 처리
    fun CallCamera(){
        if(checkPermission(CAMERA,CAMERA_CODE) && checkPermission(STORAGE,STORAGE_CODE)){
            val itt = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(itt,CAMERA_CODE)
        }
    }

    //사진저장
    fun saveFile(fileName:String,mimeType:String,bitmap: Bitmap): Uri?{
        var CV = ContentValues()

        //MediaStore에 파일명,mimeType을 지정정
        CV.put(MediaStore.Images.Media.DISPLAY_NAME,fileName)
        CV.put(MediaStore.Images.Media.MIME_TYPE,mimeType)

        //안정성 검사
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            CV.put(MediaStore.Images.Media.IS_PENDING,1)
        }

        //MediaStore에 파일을 저장
        val uri = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,CV)
        if(uri != null){
            var scriptor = contentResolver.openFileDescriptor(uri,"w")
            val fos = FileOutputStream(scriptor?.fileDescriptor)

            bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos)
            fos.close()

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                CV.clear()
                CV.put(MediaStore.Images.Media.IS_PENDING, 0)
                contentResolver.update(uri, CV, null, null)
            }
        }
        return uri
    }
    //결과
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val imageView = findViewById<ImageView>(R.id.avatars)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                CAMERA_CODE -> {
                    if(data?.extras?.get("data") != null){
                        val img = data?.extras?.get("data") as Bitmap
                        val uri = saveFile(RandomFileName(),"image/jpeg",img)
                        imageView.setImageURI(uri)
                        println("이미지경로 : $uri")
                        println("실제 이미지 경로 : " + getPath(uri))
                        imagePath = getPath(uri)

                    }
                }
                STORAGE_CODE -> {
                    val uri = data?.data
                    imageView.setImageURI(uri)
                }
            }
        }
    }

    //파일명을 날짜로 저장
    fun RandomFileName():String{

        val fileName = SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())
        return fileName
    }
    //갤러리의 경로 취득
    fun GetAlbum(){
        if(checkPermission(STORAGE,STORAGE_CODE)){
            val itt = Intent(Intent.ACTION_PICK)
            itt.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(itt,STORAGE_CODE)
        }
    }
    fun getPath(uri: Uri?): String {
        val projection = arrayOf<String>(MediaStore.Images.Media.DATA)
        val cursor: Cursor = managedQuery(uri, projection, null, null, null)
        startManagingCursor(cursor)
        val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(columnIndex)
    }


        @SuppressLint("MissingPermission")
        fun updateLocation(){
            val locationRequest = LocationRequest.create()
            locationRequest.run {
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                interval = 1000
            }

            locationCallback = object : LocationCallback(){
                // 1초에 한번씩 변경된 위치 정보가 onLocationResult 로 전달된다
                override fun onLocationResult(locationResult: LocationResult?) {
                    locationResult?.let {
                        for (location in it.locations){
                            Log.d( "위치정보", " - 위도:${location.latitude} 경도:${location.longitude}")

                            latitude = location.latitude
                            longitude = location.longitude
                        }
                    }
                }
            }
            // 권한 처리
            fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, Looper.myLooper())
        }
}