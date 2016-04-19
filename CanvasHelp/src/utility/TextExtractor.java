package utility;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.tika.detect.DefaultDetector;
import org.apache.tika.detect.Detector;
import org.apache.tika.io.TikaInputStream;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;

import Data.Assignment;
import Data.Course;

public class TextExtractor 
{ 
    private OutputStream outputstream;
    private ParseContext context;
    private Detector detector;
    private Parser parser;
    private Metadata metadata;
    private String extractedText;
    private String path; 
    
    Assignmentformer assign=new Assignmentformer();

    public TextExtractor(String recieveed) 
    {
    	//JFrame frame = new JFrame("Wordopener");
	//	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
        context = new ParseContext();
        detector = new DefaultDetector();
        parser = new AutoDetectParser(detector);
        context.set(Parser.class, parser);
        outputstream = new ByteArrayOutputStream();
        metadata = new Metadata();
        
        path=recieveed;
   
    }

    public void process() throws Exception 
    {
    	
        URL url;
        File file = new File(path);
        
        if (file.isFile()) 
        {
            url = file.toURI().toURL();
        }
        
        else 
        {
            url = new URL(path);
        }
        
        InputStream input = TikaInputStream.get(url, metadata);
        ContentHandler handler = new BodyContentHandler(outputstream);
        parser.parse(input, handler, metadata, context); 
        input.close();
    }

    public Assignment[] getString(Course arrayer) 
    {
        //Get the text into a String object
        extractedText = outputstream.toString();
        extractedText = extractedText.replace("\r\n", " ").replace("\n", " ");      
               
        return assign.extractusefuldata(extractedText, arrayer);
    }
    
  
}