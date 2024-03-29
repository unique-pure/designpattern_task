package ch4;

public class Paizhang extends Officer {
    public Paizhang(String name) {
        super(name);
    }
    @Override
    public void handleMission(Mission mission) {
        if (mission.getEnemyNumber() >= 10 && mission.getEnemyNumber() < 50) {
            System.out.println(name + "排长" + "下达代号为" + mission.getCode() + "的作战任务，敌人数量为" + mission.getEnemyNumber());
        } else {
            if (this.successor != null) {
                // 传给上级
                this.successor.handleMission(mission);
            } else {
                throw new RuntimeException("抛出异常：没有分配上级且并不是营长，不能处理任务！");
            }
        }
    }
}
