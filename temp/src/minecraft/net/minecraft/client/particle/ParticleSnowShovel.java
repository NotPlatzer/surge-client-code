package net.minecraft.client.particle;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class ParticleSnowShovel extends Particle {
   float field_70588_a;

   protected ParticleSnowShovel(World p_i1227_1_, double p_i1227_2_, double p_i1227_4_, double p_i1227_6_, double p_i1227_8_, double p_i1227_10_, double p_i1227_12_) {
      this(p_i1227_1_, p_i1227_2_, p_i1227_4_, p_i1227_6_, p_i1227_8_, p_i1227_10_, p_i1227_12_, 1.0F);
   }

   protected ParticleSnowShovel(World p_i1228_1_, double p_i1228_2_, double p_i1228_4_, double p_i1228_6_, double p_i1228_8_, double p_i1228_10_, double p_i1228_12_, float p_i1228_14_) {
      super(p_i1228_1_, p_i1228_2_, p_i1228_4_, p_i1228_6_, p_i1228_8_, p_i1228_10_, p_i1228_12_);
      this.field_187129_i *= 0.10000000149011612D;
      this.field_187130_j *= 0.10000000149011612D;
      this.field_187131_k *= 0.10000000149011612D;
      this.field_187129_i += p_i1228_8_;
      this.field_187130_j += p_i1228_10_;
      this.field_187131_k += p_i1228_12_;
      float f = 1.0F - (float)(Math.random() * 0.30000001192092896D);
      this.field_70552_h = f;
      this.field_70553_i = f;
      this.field_70551_j = f;
      this.field_70544_f *= 0.75F;
      this.field_70544_f *= p_i1228_14_;
      this.field_70588_a = this.field_70544_f;
      this.field_70547_e = (int)(8.0D / (Math.random() * 0.8D + 0.2D));
      this.field_70547_e = (int)((float)this.field_70547_e * p_i1228_14_);
   }

   public void func_180434_a(BufferBuilder p_180434_1_, Entity p_180434_2_, float p_180434_3_, float p_180434_4_, float p_180434_5_, float p_180434_6_, float p_180434_7_, float p_180434_8_) {
      float f = ((float)this.field_70546_d + p_180434_3_) / (float)this.field_70547_e * 32.0F;
      f = MathHelper.func_76131_a(f, 0.0F, 1.0F);
      this.field_70544_f = this.field_70588_a * f;
      super.func_180434_a(p_180434_1_, p_180434_2_, p_180434_3_, p_180434_4_, p_180434_5_, p_180434_6_, p_180434_7_, p_180434_8_);
   }

   public void func_189213_a() {
      this.field_187123_c = this.field_187126_f;
      this.field_187124_d = this.field_187127_g;
      this.field_187125_e = this.field_187128_h;
      if (this.field_70546_d++ >= this.field_70547_e) {
         this.func_187112_i();
      }

      this.func_70536_a(7 - this.field_70546_d * 8 / this.field_70547_e);
      this.field_187130_j -= 0.03D;
      this.func_187110_a(this.field_187129_i, this.field_187130_j, this.field_187131_k);
      this.field_187129_i *= 0.9900000095367432D;
      this.field_187130_j *= 0.9900000095367432D;
      this.field_187131_k *= 0.9900000095367432D;
      if (this.field_187132_l) {
         this.field_187129_i *= 0.699999988079071D;
         this.field_187131_k *= 0.699999988079071D;
      }

   }

   public static class Factory implements IParticleFactory {
      public Particle func_178902_a(int p_178902_1_, World p_178902_2_, double p_178902_3_, double p_178902_5_, double p_178902_7_, double p_178902_9_, double p_178902_11_, double p_178902_13_, int... p_178902_15_) {
         return new ParticleSnowShovel(p_178902_2_, p_178902_3_, p_178902_5_, p_178902_7_, p_178902_9_, p_178902_11_, p_178902_13_);
      }
   }
}
