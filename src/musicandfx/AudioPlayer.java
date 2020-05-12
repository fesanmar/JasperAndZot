package musicandfx;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer
{
	AudioInputStream ais;
	Clip ol;
	
	public AudioPlayer(String file)
	{
		File audioFile = new File(file);
		try
		{
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(audioFile);
			ais = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat af = aff.getFormat();
			DataLine.Info info = new DataLine.Info(
					Clip.class, ais.getFormat(),
					((int) ais.getFrameLength() * af.getFrameSize())
					);
			ol = (Clip) AudioSystem.getLine(info);
		} catch (UnsupportedAudioFileException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (LineUnavailableException e)
		{
			e.printStackTrace();
		}
	}
	
	public void playInfiniteLoop()
	{
		try
		{
			ol.open(ais);
			ol.loop(Clip.LOOP_CONTINUOUSLY);
		} catch (LineUnavailableException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void stop()
	{
		ol.close();
	}
}
