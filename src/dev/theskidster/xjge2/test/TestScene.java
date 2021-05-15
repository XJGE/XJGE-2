package dev.theskidster.xjge2.test;

import dev.theskidster.xjge2.core.Camera;
import dev.theskidster.xjge2.core.Game;
import dev.theskidster.xjge2.core.Scene;
import dev.theskidster.xjge2.graphics.Color;
import dev.theskidster.xjge2.shaderutils.GLProgram;
import dev.theskidster.xjge2.ui.Font;
import java.util.Map;

/**
 * @author J Hoffman
 * Created: May 7, 2021
 */

public class TestScene extends Scene {

    Font font;
    
    public TestScene() {
        super("test");
        
        font = new Font("fnt_inconsolata_regular.ttf");
        
        Game.setClearColor(Color.RETRO_BLUE);
        
        entities.put("test", new TestEntity(0, 0, -5));
    }
    
    @Override
    public void update(double targetDelta) {
        entities.values().forEach(entity -> entity.update(targetDelta));
        
        font.update();
    }

    @Override
    public void render(Map<String, GLProgram> glPrograms, Camera camera) {
        GLProgram defaultProgram = glPrograms.get("default");
        defaultProgram.use();
        
        entities.values().forEach(entity -> entity.render(defaultProgram, camera));
        
        font.render(defaultProgram);
    }

    @Override
    public void exit() {
    }

}