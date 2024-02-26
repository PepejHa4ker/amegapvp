package com.pepej.omegapvp.utils

import net.minecraft.client.renderer.entity.RenderManager
import org.lwjgl.opengl.GL11


    fun drawEspLine(
        sx: Double,
        sy: Double,
        sz: Double,
        ex: Double,
        ey: Double,
        ez: Double,
        r: Float,
        g: Float,
        b: Float,
        a: Float,
        scale: Float
    ) {
        val pX = RenderManager.renderPosX
        val pY = RenderManager.renderPosY
        val pZ = RenderManager.renderPosZ
        GL11.glPushMatrix()
        GL11.glTranslated(-pX, -pY, -pZ)
        GL11.glAlphaFunc(GL11.GL_GREATER, 0F)
        GL11.glEnable(GL11.GL_LINE_SMOOTH)
        GL11.glDisable(GL11.GL_DEPTH_TEST)
        GL11.glDisable(GL11.GL_TEXTURE_2D)
        GL11.glDisable(GL11.GL_LIGHTING)
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glColor4f(r, g, b, a)
        GL11.glLineWidth(scale)
        GL11.glDepthMask(false)
        GL11.glPushMatrix()
        GL11.glBegin(GL11.GL_LINES)
        GL11.glVertex3d(sx, sy, sz)
        GL11.glVertex3d(ex, ey, ez)
        GL11.glEnd()
        GL11.glPopMatrix()
        GL11.glEnable(GL11.GL_TEXTURE_2D)
        GL11.glEnable(GL11.GL_DEPTH_TEST)
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glDisable(GL11.GL_BLEND)
        GL11.glDepthMask(true)
        GL11.glPopMatrix()
    }

    fun drawEspBlock(x: Double, y: Double, z: Double, r: Float, g: Float, b: Float, a: Float, scale: Float) {
        val pX = RenderManager.renderPosX
        val pY = RenderManager.renderPosY
        val pZ = RenderManager.renderPosZ
        val tr = (1 - scale) / 2
        GL11.glPushMatrix()
        GL11.glTranslated(-pX, -pY, -pZ)
        GL11.glAlphaFunc(GL11.GL_GREATER, 0F)
        GL11.glDisable(GL11.GL_TEXTURE_2D)
        GL11.glDisable(GL11.GL_DEPTH_TEST)
        GL11.glDisable(GL11.GL_LIGHTING)
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glColor4f(r, g, b, a)
        GL11.glTranslated(x, y, z)
        GL11.glDepthMask(false)
        GL11.glPushMatrix()
        GL11.glTranslatef(tr, tr, tr)
        GL11.glScalef(scale, scale, scale)
        GL11.glBegin(GL11.GL_QUADS)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glEnd()
        GL11.glPopMatrix()
        GL11.glEnable(GL11.GL_DEPTH_TEST)
        GL11.glEnable(GL11.GL_TEXTURE_2D)
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glDisable(GL11.GL_BLEND)
        GL11.glDepthMask(true)
        GL11.glPopMatrix()
    }

    fun drawOutlinedEspBlock(x: Double, y: Double, z: Double, r: Float, g: Float, b: Float, a: Float, scale: Float) {
        val pX = RenderManager.renderPosX
        val pY = RenderManager.renderPosY
        val pZ = RenderManager.renderPosZ
        val tr = (1 - scale) / 2
        GL11.glPushMatrix()
        GL11.glTranslated(-pX, -pY, -pZ)
        GL11.glAlphaFunc(GL11.GL_GREATER, 0F)
        GL11.glDisable(GL11.GL_TEXTURE_2D)
        GL11.glDisable(GL11.GL_DEPTH_TEST)
        GL11.glDisable(GL11.GL_LIGHTING)
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glColor4f(r, g, b, a)
        GL11.glTranslated(x, y, z)
        GL11.glDepthMask(false)
        GL11.glPushMatrix()
        GL11.glTranslatef(tr, tr, tr)
        GL11.glScalef(scale, scale, scale)
        GL11.glBegin(GL11.GL_LINES)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(0F, 0F, 0F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(0F, 1F, 1F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(0F, 0F, 1F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glVertex3f(1F, 0F, 1F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(0F, 1F, 0F)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(1F, 0F, 0F)
        GL11.glVertex3f(1F, 1F, 0F)
        GL11.glVertex3f(1F, 1F, 1F)
        GL11.glEnd()
        GL11.glPopMatrix()
        GL11.glEnable(GL11.GL_DEPTH_TEST)
        GL11.glEnable(GL11.GL_TEXTURE_2D)
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glDisable(GL11.GL_BLEND)
        GL11.glDepthMask(true)
        GL11.glPopMatrix()
    }

    fun drawWayLine(poses: Set<DoubleArray>, r: Float, g: Float, b: Float, a: Float, w: Float) {
        val pX = RenderManager.renderPosX
        val pY = RenderManager.renderPosY
        val pZ = RenderManager.renderPosZ
        GL11.glPushMatrix()
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA)
        GL11.glDisable(GL11.GL_TEXTURE_2D)
        GL11.glEnable(GL11.GL_LINE_SMOOTH)
        GL11.glDisable(GL11.GL_DEPTH_TEST)
        GL11.glDisable(GL11.GL_LIGHTING)
        GL11.glEnable(GL11.GL_BLEND)
        GL11.glColor4f(r, g, b, a)
        GL11.glLineWidth(w)
        GL11.glBegin(GL11.GL_LINE_STRIP)
        poses.forEach {
            GL11.glVertex3d(it[0] - pX, it[1] - pY, it[2] - pZ)

        }
        GL11.glEnd()
        GL11.glDisable(GL11.GL_LINE_SMOOTH)
        GL11.glEnable(GL11.GL_DEPTH_TEST)
        GL11.glEnable(GL11.GL_TEXTURE_2D)
        GL11.glEnable(GL11.GL_LIGHTING)
        GL11.glDisable(GL11.GL_BLEND)
        GL11.glPopMatrix()
    }
