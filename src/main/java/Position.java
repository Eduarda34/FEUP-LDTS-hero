public class Position {
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    @Override
    public boolean equals(Object o){
        //literally the same position
        if (this == o) return true;
        //doesn't accept nulls
        if (o == null) return false;
        //doesn't accept different classes
        if (getClass() != o.getClass()) return false;

        Position p = (Position) o;
        return (x == p.getX() && y == p.getY());
    }
}
