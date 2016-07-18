// Adapted from http://www.sunsetlakesoftware.com/2013/10/21/optimizing-gaussian-blurs-mobile-gpu

attribute vec4 a_position;
attribute vec4 a_color;
attribute vec2 a_texCoord0;

uniform mat4 u_projTrans;
uniform vec2 stepDirection;

varying vec2 blurCoordinate0;
varying vec2 blurCoordinate1;
varying vec2 blurCoordinate2;
varying vec2 blurCoordinate3;
varying vec2 blurCoordinate4;
varying vec2 blurCoordinate5;
varying vec2 blurCoordinate6;
varying vec2 blurCoordinate7;
varying vec2 blurCoordinate8;
varying vec4 vColor;

void main()
{
	gl_Position = u_projTrans * a_position;

    vColor = a_color;

	blurCoordinate0 = a_texCoord0;
	blurCoordinate1 = a_texCoord0 + stepDirection;
	blurCoordinate2 = a_texCoord0 - stepDirection;
	blurCoordinate3 = a_texCoord0 + stepDirection * 2.0;
	blurCoordinate4 = a_texCoord0 - stepDirection * 2.0;
	blurCoordinate5 = a_texCoord0 + stepDirection * 3.0;
	blurCoordinate6 = a_texCoord0 - stepDirection * 3.0;
	blurCoordinate7 = a_texCoord0 + stepDirection * 4.0;
	blurCoordinate8 = a_texCoord0 - stepDirection * 4.0;
}