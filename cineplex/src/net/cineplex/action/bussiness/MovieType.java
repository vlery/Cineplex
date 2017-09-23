package net.cineplex.action.bussiness;

public class MovieType {
		static String[]  type={"爱情片","剧情片","喜剧片","家庭片","伦理片",
					"文艺片","音乐片","歌舞片","动漫片","西部片",
					"武侠片","古装片","动作片","恐怖片","惊悚片",
					"冒险片","犯罪片","悬疑片","记录片","战争片",
					"历史片","传记片","体育片","科幻片","魔幻片",
					"奇幻片"};
	

		public String getTypeName(int i){
			return type[i];
		}
		
	
}
