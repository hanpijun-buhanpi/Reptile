package com.lyc.reptile;

import com.lyc.reptile.factory.ReptileFactory;
import com.lyc.reptile.service.Reptile;
import com.lyc.reptile.service.impl.ImageReptileImpl;
import com.lyc.reptile.service.impl.ReptileImpl;
import com.lyc.reptile.service.impl.SaveWebFileExecutor;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        ReptileFactory.readWebImageAndSave("https://mtzxw.com/tnlhtml/tnl81.html","D:\\Resources\\Images\\Beauty\\性感");
    }
}
