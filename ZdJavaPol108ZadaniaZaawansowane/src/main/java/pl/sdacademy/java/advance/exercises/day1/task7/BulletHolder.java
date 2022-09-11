package pl.sdacademy.java.advance.exercises.day1.task7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class BulletHolder {
    // private final Stack<String> bulletHolder = new Stack<>();
    private final Deque<String> bulletHolder = new ArrayDeque<>();
    private final int maxNumberOfBullet;

    public BulletHolder(int maxNumberOfBullet) {
        this.maxNumberOfBullet = maxNumberOfBullet;
    }

    public void loadBullet(String bullet) {
        if(maxNumberOfBullet == bulletHolder.size()) {
            throw new IllegalArgumentException("Holder is full");
        }
        bulletHolder.push(bullet);
    }

    public boolean isLoaded() {
        return bulletHolder.size() >=1;
    }

    public String shot () {
        if(!isLoaded()) {
            return "Holder is empty";
        }
        return bulletHolder.pop();
    }
}
