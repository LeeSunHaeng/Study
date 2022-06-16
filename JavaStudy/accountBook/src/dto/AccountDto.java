package dto;

public class AccountDto {

	private String dateTime;	//yyyy-mm-dd(몇년 몇월 며칠)
	private String use; 		//용도(쇼핑,교통대금,핸드폰요금 등등)
	private String classify;  	//수입/지출
	private int money;			//금액
	private String memo;		//내용(특이사항)
	
	public AccountDto() {

	}

	public AccountDto(String dateTime, String use, String classify, int money, String memo) {
		super();
		this.dateTime = dateTime;
		this.use = use;
		this.classify = classify;
		this.money = money;
		this.memo = memo;
	}

	@Override
	public String toString() {
		return "AccountDto [dateTime=" + dateTime + ", use=" + use + ", classify=" + classify + ", money=" + money
				+ ", memo=" + memo + "]";
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getUse() {
		return use;
	}

	public void setUse(String use) {
		this.use = use;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
}
