public class Main {
    public static void main(String[] args) {
        int retorno;
        int[] nums = {0,0,0, 1, 1,3,3, 2, 2, 2,2};
        retorno=countClumps(nums);
        System.out.println(retorno);
    }
    public static int countClumps(int[] nums){
        int acumulador=0;
        boolean identificador=false;
        boolean cambio=false;
        for( int i=0; i<nums.length-1; i++){
            if (nums[i]==nums[i+1]){
                identificador=true;
            }else if(nums[i]!=nums[i+1]){
                cambio=true;
            }
            if (identificador == true && cambio==true){
                identificador=false;
                cambio=false;
                acumulador++;
            }
        }
        if(nums[0]==nums[1]){
            return acumulador+1;
        }
        return acumulador;
    }
}
