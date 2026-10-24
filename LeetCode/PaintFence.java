package org.example.Study.LeetCode;

public class PaintFence { //diff watch the video
    public static int fence(int fence, int color){
        int same = color; //for 2 fences there are only 2 ways we can color so that last 2 fences have same color rr,gg,bb (color =3)
        int diff = color*(color-1); // if  2 fences should have different color means it is color *(colo-1) - color * not the same color (color -1)
        int total = same + diff; // 2 fences can be colored in these 9 ways with 3 colors.

        for(int i = 3; i <= fence; i++){ // from the 3rd fence till n calculate
            same = diff * 1; // so it can be rgg,rbb so basically all the different ways possible * all the colors once
            diff = total * (color-1);
            total = same+diff;
        }
        return total;
    }
}
