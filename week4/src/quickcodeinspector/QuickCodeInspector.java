package quickcodeinspector;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.logging.*;

import javax.swing.*;

import syntaxhighlight.SyntaxHighlighter;
import syntaxhighlighter.brush.*;
import syntaxhighlighter.SyntaxHighlighterParser;
import syntaxhighlighter.theme.ThemeRDark;

public class QuickCodeInspector {

    public static void syntaxHighlighter(Path filePath){
        SyntaxHighlighterParser parser = new SyntaxHighlighterParser(new BrushXml());
        parser.setHtmlScript(true);
        parser.setHTMLScriptBrushes(Arrays.asList(new BrushJava(),new BrushJScript()));
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeRDark());
        highlighter.setFirstLine(10);
        highlighter.setHighlightedLineList(Arrays.asList(13, 27, 28, 38,42, 43,53));
        try {
            highlighter.setContent(filePath.toFile());
        } catch (IOException ex) {
            Logger.getLogger(QuickCodeInspector.class.getName()).log(Level.SEVERE, null, ex);
          }
        JFrame frame= new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
    public static void main(String[] args) {
//        String str="rsc/SendEmail.java";
        Path path=Paths.get(args[0]);
        syntaxHighlighter(path);
    }
}
