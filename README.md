# Java圖形化小遊戲(持續更新中)
原創視窗介面rpg遊戲
歡迎來爬BUG一堆的無盡之塔


# 動機
我們致力於開發一款原創的JAVA視窗介面冒險遊戲，希望透過這個項目，不僅提高我們的撰寫程式技能，還能創造一個引人入勝的遊戲體驗，將玩家帶入冒險的世界。

# UML圖
![Blank diagram (1)](https://github.com/eric-jhu/TeamJavaProject/assets/140996895/c6b54996-52c7-4ffe-9b3f-ea6bedc71ca3)


https://lucid.app/documents/view/d3cc504e-8661-4c20-9b16-c3b04156e662



# 遊戲內容介紹

  遊戲故事背景
        主角是一位冒險家，決定踏入無盡之塔，探索它的深處並尋找一種方法，以解開這座神秘塔的謎團並找到逃離的出路。
        然而，無盡之塔內充滿了各種未知的怪物和陷阱，每一層都充滿挑戰。

  主要介面:
    登入介面
    遊戲首頁
    遊戲主畫面

  功能介面:
    遊戲規則
    背包
    職業選擇
    商城

# 主要介面介紹

![初始頁面](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/5c7f251f-4589-4f2b-81a5-247bd186e482)

 提供三個功能
    1.登入:按下登入紐時跳轉到登入頁面
    2.註冊:按下登入紐時跳轉到註冊頁面
    3.離開:按離開可以結束此程式

# 登入與註冊介面介紹 

![登入](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/68b9ccb5-bf81-4520-a962-3c206973ca99)

![註冊](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/d4a00fbe-c5fd-438b-a1e4-b42433bbef92)

連動MySQL資料庫，提供使用者註冊遊戲功能，當成功註冊後，使用者下次登入，需輸入註冊之帳號密碼

# 遊戲大廳介面介紹

![遊戲主畫面](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/62b70dde-25f0-4e0d-b332-63f6b0df03dc)

  大廳提供4種功能:
    1.畫面中間Stage按鈕為進入關卡按鈕，按下進行遊戲
    2.左下按鈕為背包，按下跳至背包畫面
    3.中下方為角色按鈕，按下跳至角色畫面
    4.右下按鈕為商城，按下跳至商城畫面

# 遊戲關卡介面介紹

![遊戲畫面](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/886ec0d0-b212-41e4-b1c0-52af7c178876)

畫面中有4*4的板塊，玩法類似踩地雷，玩家要在這16個隱藏的板塊中找到通往下一層的鑰匙，但要小心隱藏在下方的怪物，盡自己所能的往下探索吧!

# 遊戲規則介面介紹 

 ![image](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/e341561a-ab07-4121-bd8c-05b271b69b0d)

提供遊戲規則介紹幫助玩家理解遊戲

# 背包介面介紹

![image](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/7ce5e5c6-e095-4160-bab5-7d2b24c9b6a4)

玩家可在背包頁面點選自己喜歡的道具裝備。點選道具會顯示裝備名稱以及裝備效果。

但一次只能裝備一個道具。

# 職業選擇介面介紹

![image](https://github.com/eric-jhu/TeamJavaProject/assets/65153061/e3e29844-6a44-41f3-921a-2d0f71e50aea)

目前有兩種職業可選擇分別是劍士與法師

劍士 (血厚,戰鬥力較低)
HP:90 ATTACK:50

法師 (血薄,戰鬥力較高)
 HP:70 ATTACK:80

 
 
      

