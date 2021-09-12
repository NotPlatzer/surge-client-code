#version 150

in vec2 outTexCoord;

out vec4 fragColor;

uniform sampler2D textureSampler;
uniform vec4 color;

void main()
{
    vec4 c = texture(textureSampler, outTexCoord).rgba;
    if (c.a == 0.0) {
        discard;
    }

    fragColor = c * color;
}