/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author nikola
 */
public class FishPatterns {

    public static void main(String[] args) {
        FishPatterns objectFish = new FishPatterns();
        objectFish.printFishSchool();
        //objectFish.printTriangle(3);

    }

    public void printFish(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ><(((’> ");
        }

    }

    public void printTriangle(int height) {
        for (int i = 1; i <= height; i++) {
            printFish(i);
        }
    }

    public void nl() {
        System.out.println();
    }

    public void printSpaces(int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(" ");
        }
    }

    public void printFishSchool() {
        int spaceCount = 18;
        int fishCount = 1;
        // За първите 4 реда
        for (int i = 0; i < 4; i++) {
            printSpaces(spaceCount);
            printFish(fishCount);
            fishCount++;
            spaceCount -= 6;
            nl();
        }
        //fishCount = 4, ама spaceCount остава -6 и това води до допълнително принтиране на реда с четири риби
        spaceCount = 0;
        //За останалите 3 реда
        for (int i=0;i<3;i++) {
            spaceCount += 6;
            fishCount--;
            printSpaces(spaceCount);
            printFish(fishCount);
            nl();
        }
    }
}
