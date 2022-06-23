package com.example.camera

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentUris
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Camera
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat

class MainActivity : AppCompatActivity() {

    // storage 권한 처리에 필요한 변수
    val CAMERA = arrayOf(Manifest.permission.CAMERA)
    val STORAGE = arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE)
    val CAMERA_CODE = 98
    val STORAGE_CODE = 99

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 카메라
        val camera = findViewById<Button>(R.id.camera)
        camera.setOnClickListener {
            CallCamera()
        }

        // 저장된 사진 보기
        val picture = findViewById<Button>(R.id.picture)
        picture.setOnClickListener {
            GetAlbum()
        }

        //val imageView = findViewById<ImageView>(R.id.imageView)
        //imageView.setImageURI(uri)

        /*val file: File = File("/storage/emulated/0/Pictures/20220216170244.jpg")
        val bExist = file.exists()
        if (bExist) {
            Log.d("++++++++++++++++","bExist")
            val myBitmap = BitmapFactory.decodeFile("/storage/emulated/0/Pictures/20220216170244.jpg")
            imageView.scaleType = ImageView.ScaleType.CENTER_INSIDE;
            imageView.setImageBitmap(myBitmap)
        }else{
            Log.d("~~~~~~~~~~~~~~~~~","!bExist")
        }*/
    }

    fun getPath(uri: Uri?): String {
        val projection = arrayOf<String>(MediaStore.Images.Media.DATA)
        val cursor: Cursor = managedQuery(uri, projection, null, null, null)
        startManagingCursor(cursor)
        val columnIndex: Int = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(columnIndex)
    }

    // 카메라 권한, 저장소 권한
    // 요청 권한
    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        when(requestCode){
            CAMERA_CODE -> {
                for (grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "카메라 권한을 승인해 주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }
            STORAGE_CODE -> {
                for(grant in grantResults){
                    if(grant != PackageManager.PERMISSION_GRANTED){
                        Toast.makeText(this, "저장소 권한을 승인해 주세요", Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }

    // 다른 권한등도 확인이 가능하도록
    fun checkPermission(permissions: Array<out String>, type:Int):Boolean{
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            for (permission in permissions){
                if(ContextCompat.checkSelfPermission(this, permission)
                    != PackageManager.PERMISSION_GRANTED){
                    ActivityCompat.requestPermissions(this, permissions, type)
                    return false
                }
            }
        }
        return true
    }

    fun createImageUri(filename: String, mimeType: String) : Uri? {
        var values = ContentValues()
        values.put(MediaStore.Images.Media.DISPLAY_NAME, filename)
        values.put(MediaStore.Images.Media.MIME_TYPE, mimeType)
        return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values)
    }

    // 카메라 원본이미지 Uri를 저장할 변
    var photoURI: Uri? = null
    private fun dispatchTakePictureIntent() {
        // 카메라 인텐트 생성
        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        createImageUri(newFileName(), "image/jpg")?.let { uri ->
            photoURI = uri
            println("실제 이미지 경로:" + getPath(uri))
            takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, photoURI)
            startActivityForResult(takePictureIntent, CAMERA_CODE)
        }
    }

    fun newFileName() : String{
        val fileName = SimpleDateFormat("yyyyMMddHHmmss").format(System.currentTimeMillis())
        return "$fileName.jpg"
    }

    fun CallCamera(){
        if(checkPermission(CAMERA, CAMERA_CODE) && checkPermission(STORAGE, STORAGE_CODE)){
            dispatchTakePictureIntent()
        }
    }

    fun loadBitmapFromMediaStoreBy(photoUri: Uri): Bitmap? {
        println("~~~~~~${photoUri}")

        var image: Bitmap? = null
        try {
            image = if (Build.VERSION.SDK_INT > 27) { // Api 버전별 이미지 처리
                val source: ImageDecoder.Source =
                    ImageDecoder.createSource(this.contentResolver, photoUri)
                ImageDecoder.decodeBitmap(source)
            } else {
                MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return image
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView = findViewById<ImageView>(R.id.avatars)
        if(resultCode == Activity.RESULT_OK) {
            when(requestCode){
                CAMERA_CODE -> {
                    if (photoURI != null) {
                        val bitmap = loadBitmapFromMediaStoreBy(photoURI!!)
                        imageView.setImageBitmap(bitmap)
                        photoURI = null // 사용 후 null 처리
                    }
                }
            }
        }
    }

    // 갤러리 취득
    fun GetAlbum(){
        if(checkPermission(STORAGE, STORAGE_CODE)){
            val itt = Intent(Intent.ACTION_PICK)
            itt.type = MediaStore.Images.Media.CONTENT_TYPE
            startActivityForResult(itt, STORAGE_CODE)
        }
    }
}




