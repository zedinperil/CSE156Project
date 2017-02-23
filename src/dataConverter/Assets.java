package dataConverter;

public abstract class Assets {
	private String Code;
	private String Type;
	private String Label;

	public Assets(String code, String type, String label) {
		super();
		this.Code = code;
		this.Type = type;
		this.Label = label;
	}

	public String getCode() {
		return Code;
	}


	public String getType() {
		return Type;
	}

	public String getLabel() {
		return Label;
	}


	
	
	
}