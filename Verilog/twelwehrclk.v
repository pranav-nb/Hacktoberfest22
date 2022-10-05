//This program represents a 12 hour clock with AM/PM indicator
//reset resets the clock to 12:00 AM. pm is 0 for AM and 1 for PM. 
//hh, mm, and ss are two BCD (Binary-Coded Decimal) digits each for hours (01-12), minutes (00-59), and seconds (00-59). 
//Reset has higher priority than enable, and can occur even when not enabled


module top_module(
    input clk,
    input reset,
    input ena,
    output pm,
    output [7:0] hh,
    output [7:0] mm,
    output [7:0] ss); 
    reg pm_temp;
    reg [3:0] ss_ones,ss_tens,mm_ones,mm_tens,hh_ones,hh_tens;
    
    wire	add_ss_ones,end_ss_ones,add_ss_tens,end_ss_tens;
    wire	add_mm_ones,end_mm_ones,add_mm_tens,end_mm_tens;
    wire	add_hh_ones,end_hh_ones_0,end_hh_ones_1,add_hh_tens,end_hh_tens_0,end_hh_tens_1;
    wire	pm_ding;
    
    assign add_ss_ones = ena;
    assign end_ss_ones = add_ss_ones && (ss_ones == 4'd9);
    always @(posedge clk)begin
        if(reset)begin
            ss_ones <= 4'b0;
        end
        else if(add_ss_ones)begin
            if(end_ss_ones)
                ss_ones <= 4'b0;
            else 
                ss_ones <= ss_ones + 4'b1;
        end
    end
    
    assign add_ss_tens = end_ss_ones;
    assign end_ss_tens = add_ss_tens && (ss_tens == 4'd5);
    always @(posedge clk)begin
        if(reset)
            ss_tens <= 4'b0;
        else if(add_ss_tens)begin
            if(end_ss_tens)
                ss_tens <= 4'b0;
            else 
                ss_tens <= ss_tens + 4'b1;
        end
    end
    
    assign add_mm_ones = end_ss_tens;
    assign end_mm_ones = add_mm_ones && (mm_ones == 4'd9);
    always @(posedge clk)begin
        if(reset)
            mm_ones <= 4'b0;
        else if(add_mm_ones)begin
            if(end_mm_ones)
                mm_ones <= 4'b0;
            else
                mm_ones <= mm_ones + 4'b1;
        end
    end
    
    assign add_mm_tens = end_mm_ones;
    assign end_mm_tens = add_mm_tens && (mm_tens == 4'd5);
	always @(posedge clk)begin
        if(reset)
            mm_tens <= 4'b0;
        else if(add_mm_tens)begin
            if(end_mm_tens)
                mm_tens <= 4'b0;
            else 
                mm_tens <= mm_tens + 4'b1;
        end
    end
    
    assign add_hh_ones = end_mm_tens;
    assign end_hh_ones_0 = add_hh_ones && (hh_ones == 4'd9);
    assign end_hh_ones_1 = add_hh_ones && ((hh_ones == 4'd2) && (hh_tens == 4'd1));
    always @(posedge clk)begin
        if(reset)
            hh_ones <= 4'd2;
        else if(add_hh_ones)begin
            if(end_hh_ones_0)
                hh_ones <= 4'b0;
            else if(end_hh_ones_1)
                hh_ones <= 4'b1;
            else 
                hh_ones <= hh_ones + 4'b1;
        end
    end

    assign add_hh_tens = end_mm_tens;
    assign end_hh_tens_0 = add_hh_tens && end_hh_ones_1;
    assign end_hh_tens_1 = add_hh_tens && end_hh_ones_0;
    always @(posedge clk)begin
        if(reset)
            hh_tens <= 4'b1;
        else if(add_hh_tens)begin
            if(end_hh_tens_0)
                hh_tens <= 4'b0;
            else if(end_hh_tens_1)
                hh_tens <= hh_tens + 4'b1;
        end
    end
    
    always@(posedge clk)begin
        if(reset)
            pm_temp <= 1'b0;
        else if(pm_ding)
            pm_temp <= ~pm_temp;
    end
    
    assign pm_ding = hh_tens == 4'd1 && hh_ones == 4'd1 && end_mm_tens;
    
    assign ss = {ss_tens, ss_ones};
    assign mm = {mm_tens, mm_ones};
    assign hh = {hh_tens, hh_ones};
    assign pm = pm_temp;

endmodule


