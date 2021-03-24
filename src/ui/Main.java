package ui;

import ast.Program;
import ast.pacManParser;
import libs.SimpleTokenizer;
import libs.Tokenizer;
import libs.Node;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        List<String> fixedLiterals = Arrays.asList("ENEMYSTART", "MAPCOLOUR", "CHARCOLOUR", "WALLCOLOUR", "ENEMYCOLOUR",
                "MOVE", "ENEMY", "LOOP", "WALL", "SIZE", "ENEMYSPEED", "UP", "DOWN", "LEFT", "RIGHT", "END", ",", "(",
                ")", "\n", "{", "}");
        Tokenizer tokenizer = SimpleTokenizer.createSimpleTokenizer("input.tdot",fixedLiterals);
        System.out.println("Done tokenizing");

        pacManParser p = pacManParser.getParser(tokenizer);
        Program program = p.parseProgram();
        System.out.println("Done parsing");

        libs.Node.setWriter("output.html");
        program.evaluate();
        System.out.println("Done evaluation");
        Node.closeWriter();
    }

}




