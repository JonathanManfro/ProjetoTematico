package projetotematico;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class ControllerMusicThread {
	
	private static String nomeArquivo;
	private static int segundos = 5;

	private Player player;
	private PlayerThread pt;

	public static void main(String [] args) {
		ControllerMusicThread exemplo = new ControllerMusicThread("C:\\Users\\manfr\\eclipse-workspace\\aqui\\ProjetoTematico\\Musica\\01 Almost with You.mp3");
		exemplo.tocar();
		try {
			Thread.sleep(segundos * 1000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
		} 
		exemplo.parar();
	}
	
	public ControllerMusicThread(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	public void tocar() {
		try {
			this.player = new Player(new FileInputStream("C:\\Users\\manfr\\eclipse-workspace\\aqui\\ProjetoTematico\\Musica\\01 Almost with You.mp3"));
			this.pt = new PlayerThread(this.player);
			System.out.println("Reproduzindo os primeiros " + segundos + " segundos do arquivo " + nomeArquivo + "...");
			this.pt.start();
			Thread.sleep(segundos * 1000);
			this.pt.end();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (JavaLayerException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void parar() {
		this.pt.end();
	}
	
	


}
