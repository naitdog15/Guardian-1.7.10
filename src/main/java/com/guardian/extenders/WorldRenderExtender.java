package com.guardian.extenders;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;
import java.util.List;

import org.apache.logging.log4j.LogManager;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import javafx.scene.shape.VertexFormat;
import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class WorldRenderExtender extends WorldRenderer
{

	

	private ByteBuffer byteBuffer;
    private IntBuffer rawIntBuffer;
    private ShortBuffer rawShortBuffer;
    private FloatBuffer rawFloatBuffer;
    private int vertexCount;
    private int vertexFormat;
    private int nextOffset;
    private int vertexFormatIndex;
    private final List<Integer> offsets;
    private VertexFormatElement vertexFormatElement;
    private final VertexFormatElement.EnumType type;
    
    
    private double xOffset;
    private double yOffset;
    private double zOffset;
	
	public WorldRenderExtender(World p_i1240_1_, List p_i1240_2_, int p_i1240_3_, int p_i1240_4_, int p_i1240_5_,
			int p_i1240_6_) {
		super(p_i1240_1_, p_i1240_2_, p_i1240_3_, p_i1240_4_, p_i1240_5_, p_i1240_6_);
		// TODO Auto-generated constructor stub
	}
	
	public int func_181720_d(int vertexFormat2)
    {
        return ((Integer)this.offsets.get(vertexFormat2)).intValue();
    }
	
	public int getNextOffset()
    {
        return this.nextOffset;
    }
	public final VertexFormatElement.EnumType getType()
    {
        return this.type;
    }

	public WorldRenderer pos(double x, double y, double z)
    {
        int i = this.vertexCount * getNextOffset() + func_181720_d(this.vertexFormat);

        switch (this.vertexFormatElement.getType())
        {
            case FLOAT:
                this.byteBuffer.putFloat(i, (float)(x + this.xOffset));
                this.byteBuffer.putFloat(i + 4, (float)(y + this.yOffset));
                this.byteBuffer.putFloat(i + 8, (float)(z + this.zOffset));
                break;
            case UINT:
            case INT:
                this.byteBuffer.putInt(i, Float.floatToRawIntBits((float)(x + this.xOffset)));
                this.byteBuffer.putInt(i + 4, Float.floatToRawIntBits((float)(y + this.yOffset)));
                this.byteBuffer.putInt(i + 8, Float.floatToRawIntBits((float)(z + this.zOffset)));
                break;
            case USHORT:
            case SHORT:
                this.byteBuffer.putShort(i, (short)((int)(x + this.xOffset)));
                this.byteBuffer.putShort(i + 2, (short)((int)(y + this.yOffset)));
                this.byteBuffer.putShort(i + 4, (short)((int)(z + this.zOffset)));
                break;
            case UBYTE:
            case BYTE:
                this.byteBuffer.put(i, (byte)((int)(x + this.xOffset)));
                this.byteBuffer.put(i + 1, (byte)((int)(y + this.yOffset)));
                this.byteBuffer.put(i + 2, (byte)((int)(z + this.zOffset)));
        }
        return this;
    }
	
	public WorldRenderExtender tex(double u, double v)
    {
        int i = this.vertexCount * this.vertexFormatElement.getNextOffset() + this.vertexFormatElement.func_181720_d(this.vertexFormatIndex);

        switch (this.vertexFormatElement.getType())
        {
            case FLOAT:
                this.byteBuffer.putFloat(i, (float)u);
                this.byteBuffer.putFloat(i + 4, (float)v);
                break;
            case UINT:
            case INT:
                this.byteBuffer.putInt(i, (int)u);
                this.byteBuffer.putInt(i + 4, (int)v);
                break;
            case USHORT:
            case SHORT:
                this.byteBuffer.putShort(i, (short)((int)v));
                this.byteBuffer.putShort(i + 2, (short)((int)u));
                break;
            case UBYTE:
            case BYTE:
                this.byteBuffer.put(i, (byte)((int)v));
                this.byteBuffer.put(i + 1, (byte)((int)u));
        }
		return null;
    }
	public void endVertex()
    {
        ++this.vertexCount;
        this.growBuffer(this.vertexFormatElement.func_181719_f());
    }
	
	public void growBuffer(int p_181670_1_)
	{
	    if (p_181670_1_ > this.rawIntBuffer.remaining())
	    {
	        int i = this.byteBuffer.capacity();
	        int j = i % 2097152;
	        int k = j + (((this.rawIntBuffer.position() + p_181670_1_) * 4 - j) / 2097152 + 1) * 2097152;
	        LogManager.getLogger().warn("Needed to grow BufferBuilder buffer: Old size " + i + " bytes, new size " + k + " bytes.");
	        int l = this.rawIntBuffer.position();
	        ByteBuffer bytebuffer = GLAllocation.createDirectByteBuffer(k);
	        this.byteBuffer.position(0);
	        bytebuffer.put(this.byteBuffer);
	        bytebuffer.rewind();
	        this.byteBuffer = bytebuffer;
	        this.rawFloatBuffer = this.byteBuffer.asFloatBuffer().asReadOnlyBuffer();
	        this.rawIntBuffer = this.byteBuffer.asIntBuffer();
	        this.rawIntBuffer.position(l);
	        this.rawShortBuffer = this.byteBuffer.asShortBuffer();
	        this.rawShortBuffer.position(l << 1);
	    }
	    
	    
	}
}
