package Epicode_first_project;

public class AudioRecording extends MultimediaElement implements Reproducible{
	private int volume;
	
	public AudioRecording(String titolo, int durata, int volume) {
	    super(titolo, durata);
	    this.volume = volume;
	  }
	
	  public int getVolume() {
		  return volume;
	  }
	  
	  public void abbassaVolume() {
		  if (volume > 0) {
			  volume--;
		  }
	  }
	  
	  public void alzaVolume() {
		  volume++;
	  }
	  
	  public void play() {
		  for (int i = 0; i < durata; i++) {
			  for (int j = 0; j < volume; j++) {
				  System.out.print("!");
			  }
			  System.out.println(titolo);
		  }
	  }

	@Override
	public void abbasaVolume() {
		// TODO Auto-generated method stub
		
	}
}
