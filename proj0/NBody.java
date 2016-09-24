import java.util.*;

public class NBody{
	public static double readRadius(String filename){
		In in = new In(filename);
		int size = in.readInt();
		double radius = in.readDouble();
		return radius;
	}
	public static Planet[] readPlanets(String filename){
		In in = new In(filename);
		int size = in.readInt();
		double radius = in.readDouble();
		Planet[] pl = new Planet[size];
		int line = 0;
		while(!in.isEmpty() & line <size){
			pl[line]= new Planet(in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readDouble(),in.readString());
			line++;
	
		}
		return pl;
		
	}
	public static String imageToDraw = "./images/starfield.jpg";

	public static void main(String[] args){
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Double radius = NBody.readRadius(filename);
		Planet[] planets = NBody.readPlanets(filename);
		//StdDraw.setPenRadius(radius);
		StdDraw.setScale(-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, imageToDraw);
		for(Planet pl:planets){
			pl.draw();
		}
		StdAudio.play("audio/2001.mid");

		for(double t =0;t<=T;t+=dt){

			Double[] xForces = new Double[planets.length];//Create an xForces array and yForces array.
			Double[] yForces = new Double[planets.length];
			for(int i =0;i<planets.length;i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);//Calculate the net x and y forces for each planet, storing these in the xForces and yForces arrays respectively.
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int j=0;j<planets.length;j++){
				planets[j].update(t,xForces[j],yForces[j]);//Call update on each of the planets.This will update each planet's position, velocity, and acceleration.
			}
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);
			for(Planet pl:planets){
				pl.draw();
			}
			StdDraw.show(10);
		}

		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
			StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
   			planets[i].xxPos, planets[i].yyPos, planets[i].xxVel, planets[i].yyVel, planets[i].mass, planets[i].imgFileName);	
		}

		
	}


}