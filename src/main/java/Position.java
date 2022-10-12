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
        if (this == o) //literally the same position
            return true;

        if (o == null) //doesn't accept nulls
            return false;

        if (getClass() != o.getClass()) //doesn't accept different classes
            return false;

        Position p = (Position) o;
        return (x == p.getX() && y == p.getY());
    }
}
