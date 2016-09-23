public class Planet{
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;
	public static final double G = 6.67300E-11;
	public Planet(double xP, double yP, double xV, double yV, double m, String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}
	public Planet(Planet p){
		this(p.xxPos,p.yyPos,p.xxVel,p.yyVel,p.mass,p.imgFileName);
	}

	public double calcDistance(Planet p){
		return Math.sqrt((p.xxPos - this.xxPos)*(p.xxPos - this.xxPos)+(p.yyPos-this.yyPos)*(p.yyPos-this.yyPos));
	}

	public double calcForceExertedBy(Planet p){
		double dis = this.calcDistance(p);
		double res = G* this.mass * p.mass/(dis*dis);
		return res;
	}

	public double calcForceExertedByX(Planet p){
		return this.calcForceExertedBy(p)*(p.xxPos-this.xxPos)/this.calcDistance(p);
	}

	public double calcForceExertedByY(Planet p){
		return this.calcForceExertedBy(p)*(p.yyPos-this.yyPos)/this.calcDistance(p);
	}

	public double calcNetForceExertedByX(Planet[] p){
		double total = 0;
		for(Planet item : p){
			if(this.equals(item))
				;
			else
				total+=this.calcForceExertedByX(item);
		}
		return total;
	}

	public double calcNetForceExertedByY(Planet[] p){
		double total = 0;
		for(Planet item : p){
			if(this.equals(item))
				;
			else
				total+=this.calcForceExertedByY(item);
		}
		return total;
	}

	public void update(double dt,double fx,double fy){
		//calculate the acceleration using the provided x and y force.
		double ax,ay,xVnew,yVnew,xPnew,yPnew= 0;
		ax = fx /this.mass;
		ay = fy/ this.mass;
		xVnew = this.xxVel + dt * ax;
		yVnew = this.yyVel + dt * ay;
		xPnew = this.xxPos + dt * xVnew;
		yPnew = this.yyPos + dt * yVnew;
		this.xxVel = xVnew;
		this.yyVel = yVnew;
		this.xxPos = xPnew;
		this.yyPos = yPnew;
	}

}