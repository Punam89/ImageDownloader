package com.example.imagedownloaderapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CategoryAdapter categoryAdapter;
    private List<CategoryModel> categoryModelList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        recyclerView=findViewById(R.id.cat_recycleview);


        categoryModelList.add(new CategoryModel("Nature","https://pixabay.com/get/gf649fb97e3fe697b6aebc2c0c2e92efa2626428f10577dcc605535e06f8c7d0a0007fadd954e688afdca8a5e192028c59cf48c1b5a45773d3060016c1e4ce240_1280.jpg"));
        categoryModelList.add(new CategoryModel("Science","https://pixabay.com/get/gd15dbec52a774b8db4ccf01c356269212ddac5e9466f560106fd6744e641060bbd462716ff1ec8abda3679eeda170ca3a133d4f8637e643b6b7c498fa23b4290_1280.jpg"));
        categoryModelList.add(new CategoryModel("Places","https://pixabay.com/get/ga9253c86076761faba2614b99e954247db820808dcee38296bdf0fd6679235cf1b526d1aeeb6a930f775471664448623cea9648966746ee64ad140fa8c94e8bb_1280.png"));
        categoryModelList.add(new CategoryModel("Animals","https://pixabay.com/get/ga57484c3ffede8f6e1b6df83a136f647a03f0b4fa8cb876cee0ee662f9b7cde5b980862109acf44cd1d3186af4b52397aaf2a129383b6a18d980f2177b9d49a2_1280.jpg"));
        categoryModelList.add(new CategoryModel("Music","https://pixabay.com/get/g2800bb6307357f0d341f0b611eca4e024cf7eab16ac92ff093603f5a3cab09fc3825ae915ba053bd507a6880c1f7e9cbf7c1344a6e0c56791a1fda7389ff8c9f_1280.png"));
        categoryModelList.add(new CategoryModel("Sports","https://pixabay.com/get/ge1ebe524f2188b71b805587e20ae672138081af98c1c1051366bd1db64b93bad8a82d838994b3ea8381e2614afbe932d0bf96f1b6a39ca42ed7c82c2e9a330cf_1280.jpg"));
        categoryModelList.add(new CategoryModel("Education","https://pixabay.com/get/g1127ce87953a5199d276f12bfb9ff7b9739fc2fabb3270c9ead0b7a48cef7bbbbbc9d891d3f7a70780e28795f3cdfd5e3a0d92fc445a9301da5eb5857f646279_1280.png"));
        categoryModelList.add(new CategoryModel("Backgrounds","https://pixabay.com/get/gb31332e2d01e8376b9fdb10850260ab48998b94666574042cf2c5abdb97a0458b9bfc4448cd88384bf62744cb4632b4abef429d5fbadc0b2e057a5064e33b89f_1280.jpg"));
        categoryModelList.add(new CategoryModel("Fashion","https://pixabay.com/get/g5ff22cea26fb05a127d91f7203ac2014a6d890869f7ace28b0fc4b9ee0191b2a183ec716d9be9fba9a753ee3ba3cea3f6d2e771c51bf967e343e647f7887755a_1280.jpg"));
        categoryModelList.add(new CategoryModel("Health","https://pixabay.com/get/gb35335c454664059dc183410d65665f4d6bdf0558040208fc3ce90eedf6bad014be59e2d4c368112c1fdd9de2ab6dc4108de73c0e0cf87d17fcd7c20d9a69666_1280.png"));
        categoryModelList.add(new CategoryModel("Religion","https://pixabay.com/get/g62943e18a1dfa0c85613ab801ed3180e3c29fcd50ff6e2a114da5bcdf9b28a9d81ca9a67e4052e3bce4b01b538550ba87a5724cbf6e8b3e0775e1847bae25f79_1280.jpg"));
        categoryModelList.add(new CategoryModel("Industry","https://pixabay.com/get/gb3dd447b8a67324770d1dd032eb4706ce1a2c20bc8283d12b7816015c769ced1d6440ca5628577670ac4615b07a275ba13ef9dd455ce69d88b8057d5a154dc92_1280.jpg"));
        categoryModelList.add(new CategoryModel("Computer","https://pixabay.com/get/g4b10a2fb521c7a1faba0e60ec2867c31be7acad59ca14c816b85fa02927a914347a5c56c46dc1fbe777d088d89718eb447f1c27a9eebbf868781ac81e769c1d9_1280.jpg"));
        categoryModelList.add(new CategoryModel("Food","https://pixabay.com/get/gef58e48553b3e38e919dfa30a09245689ef43dff21bf9bff861cf1c7ee413aa1f90c8ae7fed380fd1f35a697484653a2ac42ea25c931bd1c879b253df4d9b823_1280.jpg"));
        categoryModelList.add(new CategoryModel("Travel","https://pixabay.com/get/g9400d9748d556da0ae97f947ccebddd7bf89741c22b7f38609362619a53fdefa3228d10c67296677e408ff8c6e764b3759042c1f06251ed582cd5b7e579f00ea_1280.jpg"));
        categoryModelList.add(new CategoryModel("Business","https://pixabay.com/get/gc512905f6b839c99ad91299473529b6d5663a559bb4c6f722161bcca2e4f25a850973a34e9eeac0889078844fbcc3de13bd5d02014dff6828a2ac4325dd0201f_1280.jpg"));
        categoryModelList.add(new CategoryModel("Buildings","https://pixabay.com/get/g88de9ec4277118f1893bc9046b22761b66832c8d2f78e03abdddf3148750bce90bb7dd25f29e267a4ead804a58fc751dcdd74e762855e8fec91016d901850df4_1280.jpg"));
        categoryModelList.add(new CategoryModel("People","https://pixabay.com/get/g4ab20380a8b396ae1b91c8937f56e994d33827c9be582d150a8d2d078dec247e66096a4aed68bb77324152574727abc9b58ddd9ef4be28f7b23b1d714a91df8c_1280.jpg"));
        
        categoryAdapter=new CategoryAdapter(categoryModelList,getApplicationContext());
        final GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2, GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(categoryAdapter);
        categoryAdapter.notifyDataSetChanged();

    }
}