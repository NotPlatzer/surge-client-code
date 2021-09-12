#version 120

varying vec4 outColor;
varying vec2 outTexCoords;

void main()
{
    outColor = gl_Color;
    outTexCoords = gl_MultiTexCoord0.xy;
    gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
}
