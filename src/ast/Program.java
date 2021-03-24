package ast;

import libs.Node;

import java.util.ArrayList;
import java.util.List;

public class Program extends Node {
    private List<Statement> statements = new ArrayList<>();

    public Program(List<Statement> statements) {
        this.statements = statements;
    }

    @Override
    public void evaluate() {
        writer.println("");
        for (Statement s : statements){
            s.evaluate();
        }
        writer.println("}");
    }
}
