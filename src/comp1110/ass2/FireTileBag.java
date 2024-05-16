//package comp1110.ass2;
//
//public class FireTileBag {
//    private String firetilebag;
//    private int length;
//    public int getLength(){
//        return length;
//    }
//    public String getfiretilebag(){
//        return firetilebag;
//    }
//    public void createfiretilebag(String firetilebag){
//        this.firetilebag=firetilebag;
//        this.length=firetilebag.length();
//    }
//    public FireTile getfiretile(char ID) {
//        for (int i = 0; i < length; i++) {
//            if (ID == firetilebag.charAt(i)) {
//                firetilebag = firetilebag.replaceFirst(Character.toString(ID), "");
//                this.length = length - 1;
//                return FireTile.newFireTile(ID);
//            }
//        }
//        System.out.println("Not the corresponding firetile");
//        return null;
//    }
//    }
