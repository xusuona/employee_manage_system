package cn.xusuona.pojo;

public class Department {
    private int depId;
    private String depName;
    private String depLeader;

    public int getDepId() {
        return depId;
    }

    public void setDepId(int depId) {
        this.depId = depId;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public String getDepLeader() {
        return depLeader;
    }

    public void setDepLeader(String depLeader) {
        this.depLeader = depLeader;
    }

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", depName='" + depName + '\'' +
                ", depLeader='" + depLeader + '\'' +
                '}';
    }
}
