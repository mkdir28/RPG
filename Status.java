public class Status {
    Character [] status;
    Character isAlly;

    public Status(){
        int monster = 10;
        int ally = 5;
        status = new Character[monster+ally];
        for(int i = 0; i<monster;i++){
            status[i] = new Monster(10);
        }
        for(int j = monster;j<ally+monster;j++){
            status[j] = new Character();
        }
    }

    public Status(Character isAlly, Character [] status){
        this.isAlly = isAlly;
        this.status = status;
    }

    public Character[] getStatus() {
        return status;
    }

    public void setStatus(Character[] status) {
        this.status = status;
    }

    public Character getisAlly() {
        return isAlly;
    }

    public void setisAlly(Character isAlly) {
        this.isAlly = isAlly;
    }    
}
