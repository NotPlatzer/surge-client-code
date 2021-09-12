#version 150

in vec4 outColor;
in vec2 outTexCoords;

out vec4 FragColor;

uniform sampler2D textureIn;
uniform float bedColor;
uniform vec2 override;
uniform vec4 uv[5];
uniform bool skip;

const vec3 luminance = vec3(0.2126, 0.7152, 0.0722);

vec3 rgb2hsv(vec3 c)
{
    vec4 K = vec4(0.0, -1.0 / 3.0, 2.0 / 3.0, -1.0);
    vec4 p = c.g < c.b ? vec4(c.bg, K.wz) : vec4(c.gb, K.xy);
    vec4 q = c.r < p.x ? vec4(p.xyw, c.r) : vec4(c.r, p.yzx);
    float d = q.x - min(q.w, q.y);
    float e = 1.0e-10;
    return vec3(abs(q.z + (q.w - q.y) / (6.0 * d + e)), d / (q.x + e), q.x);
}

vec3 hsv2rgb(vec3 c)
{
    vec4 K = vec4(1.0, 2.0 / 3.0, 1.0 / 3.0, 3.0);
    vec3 p = abs(fract(c.xxx + K.xyz) * 6.0 - K.www);
    return c.z * mix(K.xxx, clamp(p - K.xxx, 0.0, 1.0), c.y);
}

void main() {
    vec4 color = texture(textureIn, outTexCoords);
    FragColor = color * outColor;

    if (!skip) {
        if (override.x > 0) {
            vec3 grayScale = vec3(dot(color.rgb, luminance));
            color.rgb = override.y > 0 ? grayScale : vec3(1 - grayScale.x, 1 - grayScale.y, 1 - grayScale.z);
        } else  {
            vec3 current = rgb2hsv(color.rgb);
            current.r = 0;
            current.r += bedColor;
            color.rgb = hsv2rgb(current);
        }
        for (int i = 0; i < 5; i++) {
            if (outTexCoords.x > uv[i].x && outTexCoords.x < uv[i].y &&
            outTexCoords.y > uv[i].z && outTexCoords.y < uv[i].w) {
                FragColor = color;
            }
        }
    }
}