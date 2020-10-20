package musicandfx;

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
		try
		{
			AudioFileFormat aff = AudioSystem.getAudioFileFormat(getClass().getClassLoader().getResource(file));
			ais = AudioSystem.getAudioInputStream(getClass().getClassLoader().getResource(file));
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
	
	public void play(int loops)
	{
		try
		{
			ol.open(ais);
			ol.loop(0);

		} catch (LineUnavailableException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void stop()
	{
		ol.close();
	}
}
