package PPJ.FirstSemester.Cwiczenia20;

public class Ball
{
    public double radius;
    public int ballCounter = 0;

    public void makeBall()
    {
        ballCounter++;
        this.radius = Math.random() * 10 + 10;
    }

    public int ballCounter()
    {
        return ballCounter;
    }
}
