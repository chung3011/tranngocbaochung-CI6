public class Vector2d {
    public float x;
    public float y;

    public Vector2d(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public Vector2d(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2d set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2d set(Vector2d vector2d){
        return this.set(vector2d.x, vector2d.y);
    }
    //
    public Vector2d addUp(float x, float y){
        this.x += x;
        this.y += y;
        return this;
    }
    public Vector2d addUp(Vector2d vector2d){
        return this.addUp(vector2d.x, vector2d.y);
    }

    public Vector2d add(float x, float y){
        return new Vector2d( this.x + x, this.y + y);
    }
    public Vector2d add(Vector2d vector2d){
        return this.add(vector2d.x, vector2d.y);
    }
    //
    public Vector2d subtractBy(float x, float y){
        this.x -= x;
        this.y -= y;
        return this;
    }
    public Vector2d subtractBy(Vector2d vector2d){
        return this.subtractBy(vector2d.x, vector2d.y);
    }

    public Vector2d subtract(float x, float y){
        return new Vector2d( this.x - x, this.y - y);
    }
    public Vector2d subtract(Vector2d vector2d){
        return this.subtract(vector2d.x, vector2d.y);
    }
    //
    public Vector2d multiply(float k){
        this.x = this.x*k;
        this.y = this.y*k;
        return this;
    }
    //
    public float length (){
        return (float)(Math.sqrt((double)( this.x * this.x + this.y * this.y)));
    }
    //
    public Vector2d copy (){
        return new Vector2d(this.x,this.y);
    }
    //
    public Vector2d normalize() {
        float length = this.length();
        return new Vector2d( this.x/length, this.y/length);
    }
    //
    public Vector2d rotate (double angle){
        double rad = Math.toRadians(angle);
        float cos = (float) Math.cos(rad);
        float sin = (float) Math.sin(rad);
        return new Vector2d(this.x * cos - this.y * sin, this.x * sin + this.y * cos);
    }
}
