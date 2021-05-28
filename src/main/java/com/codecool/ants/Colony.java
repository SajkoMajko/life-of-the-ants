package com.codecool.ants;

import com.codecool.ants.view.Display;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.awt.Event.ENTER;

public class Colony {
    private final int WIDTH;
    private List<Ant> ants;
    private Ant queen;
    private List<String> log = new ArrayList<>();

    public Colony(int WIDTH, int nrOfDrones, int nrOfWorkers, int nrOfSoldiers) {
        this.WIDTH = WIDTH;
        this.ants = new ArrayList<Ant>();
        this.queen = new Queen(this);
        ants.add(queen);
        generateAnt(nrOfDrones, nrOfWorkers, nrOfSoldiers);
        refreshScreen();
        addLog("Queen's mating mood: " + getQueen().getMatingMood());
        this.display(generateMap());
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public Character[][] generateMap() {
        Character[][] map = new Character[WIDTH][WIDTH];
        for (Ant ant : ants) {
            map[ant.position.getX()][ant.position.getY()] = ant.getIcon();
        }
        return map;
    }

    public void display(Character[][] map) {
        StringBuilder mapDraw = new StringBuilder();
        for (Character[] row : map) {
            for (Character field : row) {
                mapDraw.append((field == null ? '.' : field) + " ");
            }
            mapDraw.append(System.lineSeparator());
        }

        System.out.println(mapDraw);
        for (String message : log) {
            System.out.println(message);
        }
        log.clear();
    }

    public void generateAnt(int nrOfDrones, int nrOfWorkers, int nrOfSoldiers) {
        for (int i =0; i < nrOfDrones; i++) {
            ants.add(new Drone(this));
        }

        for (int i =0; i < nrOfWorkers; i++) {
            ants.add(new Worker(this));
        }

        for (int i =0; i < nrOfSoldiers; i++) {
            ants.add(new Soldier(this));
        }
    }

    private void onKeyPress(KeyEvent keyEvent) {
        switch(keyEvent.getKeyCode()) {
            case ENTER:
                update();
                break;
            case 'q' | 'Q':  //or case 'Q'
                System.exit(0);
        }
    }

    public void play() {
        do {
            Scanner scanner = new Scanner(System.in);
            //scanner.next() is NOT able to handle hitting ENTER alone (only if hitting a character + ENTER)
//            String input = scanner.next();
            //scanner.nextLine() is able to handle both case (case1: hitting ENTER alone; case2: character + ENTER)
//            System.out.println(Display.WHITE_BOLD + "\nPress enter to make the ants move!" + Display.RESET);
            String input = scanner.nextLine();


            if ("q".equals(input.toLowerCase())) System.exit(0);
            update();
        } while (true);
    }

    private void update() {
        for (Ant ant : ants) {
            ant.move();
        }

        refreshScreen();
        display(generateMap());
//        displayQueensMatingMood();
    }

    //Clear the console: https://stackoverflow.com/questions/2979383/java-clear-the-console
    //Shorter version for Linux
    public static void refreshScreen() {
//        System.out.print("\033\143");
    }

    //Longer version for Linux
//    public static void refreshScreen() {
//        System.out.print("\033[H\033[2J");
//        System.out.flush();
//    }

    public Queen getQueen() {
        return (Queen) queen;
    }

    public boolean isOnMap(int x, int y) {
        return x >= 0 && x < WIDTH &&
                y >= 0 && y < WIDTH;
    }

    public void addLog(String message) {
        log.add(message);
    }
}
