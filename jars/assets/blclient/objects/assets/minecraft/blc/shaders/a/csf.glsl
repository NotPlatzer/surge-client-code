#version 150

out vec4 FragColor;

uniform vec2 resolution;
uniform sampler2D image;
uniform float saturation;
uniform bool grayScale;

const vec3 luminance = vec3(0.2126, 0.7152, 0.0722);

void main() {
    vec2 uv = vec2(gl_FragCoord.xy/resolution);
    vec4 color = texture(image, uv);
    float lum = dot(color.rgb, luminance);
    if (grayScale) {
        FragColor = vec4(vec3(lum), 1.0);
    } else {
        vec3 diff = color.rgb - vec3(lum);
        FragColor = vec4(diff * saturation + lum, 1.0);
    }
}
