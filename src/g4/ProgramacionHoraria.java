package g4;

public class ProgramacionHoraria implements java.io.Serializable{
	private String dia;
	private Integer modulo;
	private String sala;
	
	public ProgramacionHoraria(String dia, Integer modulo, String sala){
		this.dia = dia;
		this.modulo = modulo;
		this.sala = sala;
	}
	
	public String getDia(){ return dia;}
	public Integer getModulo(){ return modulo;}
	public String getSala(){ return sala;}
	
	public String getDiaEnFormato() { 
		String diaCorto;
		switch(dia){
		case "Lunes":
			diaCorto = "lu";
		case "Martes":
			diaCorto = "ma";
		case "Miercoles":
			diaCorto = "mi";
		case "Jueves":
			diaCorto = "ju";
		case "Viernes":
			diaCorto = "vi";
		case "Sabado":
			diaCorto = "sa";
		default:
			diaCorto = "lu";
		}
		return diaCorto+":"+modulo.toString();
		}
}
