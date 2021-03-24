package ast;

import libs.Tokenizer;

import java.util.ArrayList;
import java.util.List;

public class pacManParser {
    private Tokenizer tokenizer;

    public static pacManParser getParser(Tokenizer tokenizer) {
        return new pacManParser(tokenizer);
    }

    private pacManParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    //PROGRAM  ::= SIZE WALLS+ ENEMIES+ WALLCOLOUR MAPCOLOUR CHARCOLOUR END
    public Program parseProgram() {
        List<Statement> statements = new ArrayList<>();
        tokenizer.getAndCheckNext("SIZE");
        statements.add(parseSize());
        while(!tokenizer.checkToken("END")){
            if (tokenizer.checkToken("WALL")) {
                statements.add(parseWall());
            } else if (tokenizer.checkToken("ENEMY")) {
                statements.add(parseEnemy());
            } else if (tokenizer.checkToken("WALLCOLOUR")) {
                statements.add(parseWallColour());
            } else if (tokenizer.checkToken("MAPCOLOUR")) {
                statements.add(parseMapColour());
            } else if (tokenizer.checkToken("CHARCOLOUR")) {
                statements.add(parseCharacterColour());
            } else {
                throw new RuntimeException("Unexpected next token for Parsing!");
            }
        }
        tokenizer.getNext(); // consume the "Thanks!" - not strictly necessary but good practice to consume the tokens that belong to the full rule: if you extended the language to inputs with subsequent tokens, this would become important
        return new Program(statements);
    }

    public Map parseSize(){
        return null;
    }

    // WALL ::== “BUILDWALL(“  NUMBER  “,”   NUMBER   “,”   NUMBER  “,”  NUMBER  “) “\n”
    public Wall parseWall(){
        String startx, starty, width, length;
        tokenizer.getAndCheckNext("BUILDWALL");
        tokenizer.getAndCheckNext("(");
        startx = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        starty = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        width = tokenizer.getNext();
        tokenizer.getAndCheckNext(",");
        length = tokenizer.getNext();
        tokenizer.getAndCheckNext(")");

        return null;
    }

    // ENEMY::== LOOP “\n” ENEMYCOLOUR “\n” ENEMYSPEED
    public Enemy parseEnemy(){
        return null;
    }

    // WALLCOLOUR ::== “WALLCOLOUR #” HEXVALUE{6}
    public WallColour parseWallColour(){
        return null;
    }

    // MAPCOLOUR :== “MAPCOLOUR #” HEXVALUE{6}
    public MapColour parseMapColour(){
        return null;
    }

    // CHARCOLOUR :== “CHARCOLOUR #” HEXVALUE{6}
    public CharacterColour parseCharacterColour(){
        return null;
    }


}
