package jp.ac.uryukyu.ie.e185714;

/**
 * Hero.javaとEnemy.javaの共通部分をまとめたクラス。
 */

public class LivingThing {
    private String name;
    private int hitPoint;
    private int attack;
    private boolean dead;

    /**
     * コンストラクタ。
     * @param name キャラクターの名前
     * @param maximumHP 最大体力
     * @param attack 攻撃力
     */
    public LivingThing (String name, int maximumHP, int attack) {
        this.name = name;
        this.hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
    }

    /**
     * nameのgetterメソッド。
     * @return name キャラクターの名前
     */
    public String getName(){
        return name;
    }

    /**
     * nameのsetterメソッド。
     * @param name キャラクターの名前
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * hitPointのgetterメソッド。
     * @return hitPoint その時点の体力
     */
    public int getHitPoint(){
        return hitPoint;
    }

    /**
     * hitPointのsetterメソッド。
     * @param hitPoint 体力
     */
    public void setHitPoint(int hitPoint){
        this.hitPoint = hitPoint;
    }

    /**
     * attackのgetterメソッド。
     * @return attack 攻撃力
     */
    public int getAttack(){
        return attack;
    }

    /**
     * attackのsetterメソッド。
     * @param attack 攻撃力
     */
    public void setAttack(int attack){
        this.attack = attack;
    }

    /**
     * deadのgetterメソッド。
     * @return dead trueまたはfalse
     */
    public boolean isDead() {
        return dead;
    }

    /**
     * deadのsetterメソッド。
     * @param dead trueまたはfalse
     */
    public void setDead(boolean dead){
        this.dead = dead;
    }

    /**
     * 勇者またはモンスターが相手に攻撃するメソッド。
     * @param opponent 敵キャラクター
     */
    public void attack(LivingThing opponent){
        if (!isDead()) {
            int damage = (int) (Math.random() * attack);
            System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
            opponent.wounded(damage);
        }
    }

    /**
     * キャラクターが攻撃を受けるメソッド。
     * @param damage ダメージ量
     */
    public void wounded(int damage){
        hitPoint -= damage;
        if( hitPoint < 0 ) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}