package it.unibo.isaccoop.model.room;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        var lvlFactory = new LevelFactoryImpl();
        for (int i = 0; i < 20; i++) {            
            var lvl = lvlFactory.createLevel(25, 6, 5);
            System.out.println("\nTEST: lvl = "+ lvl + "\n");
        }
        //da levelfactoryImpl
        /*
        System.out.println("createLevel(): this.roomCoords: " + this.roomCoords 
                + "\n size= " + this.roomCoords.size()
                + "\n size == numberOFRooms?: " + (this.roomCoords.size() == numberOfRooms));


 System.out.println("createLevel():"); 
        rooms.forEach(r -> System.out.println("\nRoom id= " + r.getID() + "\t (WxH): (" + r.getWidth() + " x " + r.getHeight() + ")"
                + "\nCoord: " + r.getCoord() + "\t RoomType= " + r.getRoomType() 
                + "\nDoors" + r.getDoors() 
                + "\nRoomAi" + r.getRoomAI()));
         */
        
    }
}
