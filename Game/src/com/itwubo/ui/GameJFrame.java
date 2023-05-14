package com.itwubo.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.Objects;
import java.util.Random;


public class GameJFrame extends JFrame implements KeyListener, ActionListener {
    //二维数组用来存放照片
    int[][] arr = new int[4][4];
    int win[][]=new int[][]{{1, 5, 9, 13},
            {2, 6, 10, 14},
            {3, 7, 11, 15},
            {4, 8, 12, 0}
    };
    //记录多少步
    int count=0;
    //主页面
    //声明两个变量来记录空白照片的索引
    int x = 0;
    int y = 0;
    //声明一个变量记录路径
    String path = "image/animal/animal3/";


    public GameJFrame() {
        //初始化界面
        intiJrame();
        //初始化菜单
        initJMenuBar();
        //初始化数据
        initData();
        //初始化图片
        initimage();
        //是否显示页面,建议写在最后
        this.setVisible(true);
    }

    private void initData() {
        int tempArr[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random r = new Random();
        //打乱数组
        for (int i = 0; i < tempArr.length; i++) {
            int index = r.nextInt(tempArr.length);
            int temp = tempArr[i];
            tempArr[i] = tempArr[index];
            tempArr[index] = temp;
        }
        //遍历一维数组,给二维数组复制
        for (int i = 0; i < tempArr.length; i++) {
            //如果二维数组里面存放的数字是0,则返回当前索引
            if (tempArr[i] == 0) {
                x = i / 4;
                y = i % 4;
            }
                arr[i / 4][i % 4] = tempArr[i];

        }
    }

    private void initimage() {
        //清除原来的所有图片----每次调用都是重新加载(为移动后重制画面)
        this.getContentPane().removeAll();

        /* 判断是否成功 */
        if (victory()){
            JLabel win=new JLabel(new ImageIcon("image/win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }

        //加入计步
        JLabel septcount=new JLabel("步数:"+count);
        septcount.setBounds(50,20,100,20);
        this.getContentPane().add(septcount);

        //先添加的图片在前面
        for (int j = 0; j < 4; j++) {
            for (int i = 0; i < 4; i++) {
                int num = arr[i][j];
                //创建一个图像对象
                ImageIcon icon = new ImageIcon(path + num + ".jpg");
                //创建一个JLable容器,把图片放进去
                JLabel jLabel = new JLabel(icon);
                jLabel.setBounds(i * 105 + 83, j * 105 + 134, 105, 105);
                //把容器放到界面上
                this.getContentPane().add(jLabel);
            }
        }
        //添加背景图片
        //创建一个jLabel容器,把图片放进去
        JLabel background = new JLabel(new ImageIcon("image/background.png"));
        //容器的位置及大小
        background.setBounds(40, 40, 508, 560);
        //给图片加边框
        background.setBorder(new BevelBorder(1));

        //把容器放添加到页面中
        this.getContentPane().add(background);

        //刷新页面
        this.getContentPane().repaint();
    }
    JMenuItem reLoginGame = new JMenuItem("重新登录");
    JMenuItem reGame = new JMenuItem("重新游戏");
    JMenuItem closeGame = new JMenuItem("关闭游戏");
    JMenuItem accontItem = new JMenuItem("公众号");

    private void initJMenuBar() {
        JMenuBar jmenubar = new JMenuBar();

        JMenu fanctionJmenu = new JMenu("功能");
        JMenu aboutJmenu = new JMenu("关于我们");



        //给条目绑定事件
        reLoginGame.addActionListener(this);
        reGame.addActionListener(this);
        closeGame.addActionListener(this);
        accontItem.addActionListener(this);

        fanctionJmenu.add(reLoginGame);
        fanctionJmenu.add(reGame);
        fanctionJmenu.add(closeGame);
        aboutJmenu.add(accontItem);

        jmenubar.add(fanctionJmenu);
        jmenubar.add(aboutJmenu);

        this.setJMenuBar(jmenubar);
    }

    private void intiJrame() {
        this.setSize(603, 680);//窗口大小

        this.setTitle("拼图 v1.0");//标题
        this.setLocationRelativeTo(null);//居中显示
        this.setAlwaysOnTop(true);//始终显示在最上层
        this.setDefaultCloseOperation(3);//设置关闭模式

        //取消居中放置
        this.setLayout(null);

        //添加监听键盘事件
        this.addKeyListener(this);
    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按下按键
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == 65) {
            //清除所有图片
            this.getContentPane().removeAll();
            //将全景图加入到界面中
            JLabel all = new JLabel(new ImageIcon(path + "all.jpg"));
            all.setBounds(83, 134, 420, 420);
            this.getContentPane().add(all);

            //添加背景图片
            //创建一个jLabel容器,把图片放进去
            JLabel background = new JLabel(new ImageIcon("image/background.png"));
            //容器的位置及大小
            background.setBounds(40, 40, 508, 560);
            //给图片加边框
            background.setBorder(new BevelBorder(1));

            //把容器放添加到页面中
            this.getContentPane().add(background);

            //刷新页面
            this.getContentPane().repaint();
        }

    }
    //松开按键
    @Override
    public void keyReleased(KeyEvent e) {//坐标轴混了,下面的代码有点小问题
        if (victory()){
            return;
        }
        int code = e.getKeyCode();
        //左 37 上 38 右 39 下 40
        //操作空白块

        if (code == 38) {
            //if解决越界问题
            if (y == 0) {
                return;
            }
            System.out.println("向上移动");
            //空白快向左移动一次,空白所对应的内容被原来左边的数字覆盖
            arr[x][y] = arr[x][y - 1];
            //移动完成,给当前空白所对应的内容设成0
            arr[x][y - 1] = 0;
            //移动过后,空白所对应y位置的索引-1;
            y--;
            count++;
            //调用方法,按照最新数字加载图片
            initimage();
        } else if (code == 39) {
            if (x == 3) {
                return;
            }
            System.out.println("向右移动");
            arr[x][y] = arr[x + 1][y];
            arr[x + 1][y] = 0;
            x++;
            count++;

            initimage();
        } else if (code == 40) {
            if (y == 3) {
                return;
            }
            System.out.println("向下移动");
            arr[x][y] = arr[x][y + 1];
            arr[x][y + 1] = 0;
            y++;
            count++;
            initimage();
        } else if (code == 37) {
            if (x == 0) {
                return;
            }
            System.out.println("向左移动");
            arr[x][y] = arr[x - 1][y];
            arr[x - 1][y] = 0;
            x--;
            count++;
            initimage();
            //松开A键以后重新加载图片
        } else if (code == 65) {
            initimage();
            //松开w一键通关
        } else if (code == 87) {
            arr = new int[][]{{1, 5, 9, 13},
                               {2, 6, 10, 14},
                              {3, 7, 11, 15},
                              {4, 8, 12, 0}
            };
            initimage();
        }
    }
    //如果arr中的数据和win中的数据一致,则表示成功
    //全部一致返回true,有一个不用都返回false;
    private boolean victory() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0 ; j <arr[i].length ; j++) {
                if (arr[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
        if (obj==reGame){
            System.out.println("重新游戏");
            //计步器置零
            count=0;
            //再次打乱二维数组的数据
            initData();
            //加载页面
            initimage();
        } else if (obj==reLoginGame) {
            System.out.println("重新登录");
            //关闭当前界面
            this.setVisible(false);
            //打开登录假面
            new LoginJFrame();
        } else if (obj==closeGame) {
            System.out.println("关闭游戏");
        }else if (obj==accontItem) {
            System.out.println("关于我们");
        }
    }
}
