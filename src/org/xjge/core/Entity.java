package org.xjge.core;

import org.xjge.graphics.GLProgram;
import java.util.Map;
import org.joml.Vector3f;

//Created: May 7, 2021

/**
 * Abstract class which can be used to represent dynamic game objects within 
 * the game world.
 * 
 * @author J Hoffman
 * @since  2.0.0
 */
public abstract class Entity {

    private boolean remove;
    
    public final Vector3f position;
    
    /**
     * Creates a new instance of an entity object. Most subclasses will likely 
     * overload this with their own arguments.
     * 
     * @param position the initial position of this entity in the game world
     */
    protected Entity(Vector3f position) {
        this.position = position;
    }
    
    /**
     * Used to organize entity game logic.
     * 
     * @param targetDelta a constant value denoting the desired time (in 
     *                    seconds) it should take for one game tick to complete
     * @param trueDelta   the actual time (in seconds) it took the current game
     *                    tick to complete.
     */
    public abstract void update(double targetDelta, double trueDelta);
    
    /**
     * Used to organize calls to the OpenGL API and other code pertaining to
     * rendering.
     * 
     * @param glProgram      the shader program that will be used to render 
     *                       this entity
     * @param camera         the camera object of the current viewport whos 
     *                        turn it is to complete a render pass
     * @param lights         an array of light source objects provided by the 
     *                        current scene
     * @param depthTexHandle the handle of the texture generated by the current
     *                        shadow map or -1 if one has not been set
     * 
     * @see render(Map, Camera, Light[], int)
     */
    public abstract void render(GLProgram glProgram, Camera camera, Light[] lights, int depthTexHandle);
    
    /**
     * Used to organize calls to the OpenGL API and other code pertaining to
     * rendering.
     * <p>
     * This variant of the render method allows entities to utilize multiple 
     * shader programs.
     * 
     * @param glPrograms     an immutable collection containing the shader 
     *                       programs compiled during startup
     * @param camera         the camera object of the current viewport whos 
     *                        turn it is to complete a render pass
     * @param lights         an array of light source objects provided by the 
     *                        current scene
     * @param depthTexHandle the handle of the texture generated by the current
     *                        shadow map or -1 if one has not been set
     * 
     * @see render(GLProgram, Camera, Light[], int)
     */
    public abstract void render(Map<String, GLProgram> glPrograms, Camera camera, Light[] lights, int depthTexHandle);
    
    /**
     * Used to cast a shadow using this entities model matrix (and texture if 
     * necessary) by passing them as uniforms to the depth program.
     * 
     * @param depthProgram the shader program provided by the engine that will 
     *                      be used to generate the shadow map texture
     */
    public abstract void renderShadow(GLProgram depthProgram);
    
    /**
     * Used to free the resources used by the entity once it is no longer 
     * needed.
     * <p>
     * NOTE: This method should <i>only</i> be used to deallocate memory. Death 
     * animations and other effects should be included in the entities game 
     * logic via the {@link update update()} method.
     * 
     * @see org.xjge.graphics.Graphics#freeBuffers()
     * @see org.xjge.graphics.Texture#freeTexture()
     */
    protected abstract void destroy();
    
    /**
     * Requests the removal and destruction of this entity.
     */
    public void remove() {
        remove = true;
    }
    
    /**
     * Finds if the entity has made a request for removal from the game world. 
     * <p>
     * If a removal request has been made, the entity will be 
     * {@linkplain destroy destroyed} and subsequently removed from the current 
     * scenes {@linkplain Scene#entities entity collection}.
     * 
     * @return true if the entity has requested removal
     */
    public boolean removalRequested() {
        if(remove) destroy();
        return remove;
    }
    
}