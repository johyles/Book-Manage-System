package cn.smbms.service.lend;

import cn.smbms.dao.lend.lendMapper;
import cn.smbms.pojo.Book;
import cn.smbms.pojo.Class;
import cn.smbms.pojo.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Author: fusheng-ji
 * @time: 2020/6/10 10:38
 * @description:
 */
@Service
public class LendServiceImpl implements LendService{
    @Autowired
    private lendMapper lendMapper;


    @Override
    /**
     *
     *
     * @description:
     * @param uid
     * @param bookName
     * @param classid
     * @return: java.util.List<cn.smbms.pojo_book.Info>
     * @author: fusheng-ji
     * @time: 2020/6/10 14:25
     */
    public List<Info> findInfo(Integer uid, String bookName) {
        Integer bid;
        if(bookName!=null&&bookName!=""){
            bid=lendMapper.findBidByBname(bookName);
        }else{
            bid=null;
        }
        return this.lendMapper.findInfo(uid,bid);
    }

    @Override
    /**
     *
     *
     * @description:
     * @param
     * @return: java.util.List<cn.smbms.pojo_book.Class>
     * @author: fusheng-ji
     * @time: 2020/6/10 14:25
     */
    public List<Class> getclassList() {
        return this.lendMapper.getclassList();
    }

    @Override
    /**
     *
     *
     * @description: 
     * @param uid
     * @param bid
     * @return: void
     * @author: fusheng-ji
     * @time: 2020/6/10 16:17
     */ 
    public void returnBook(Integer uid, Integer bid) {
        lendMapper.returnBook(uid,bid);
    }

    @Override
    /**
     *
     *
     * @description:
     * @param bname
     * @param class_id
     * @return: java.util.List<cn.smbms.pojo.Book>
     * @author: fusheng-ji
     * @time: 2020/6/10 19:38
     */
    public List<Book> findBook(String bname, Integer class_id) {
        return this.lendMapper.findBook(bname,class_id);
    }

    @Override
    /**
     *
     *
     * @description: 
     * @param uid
     * @param bid
     * @param class_id
     * @param lend_date
     * @param back_date
     * @return: void
     * @author: fusheng-ji
     * @time: 2020/6/10 20:38
     */ 
    public int addlend(Integer uid, Integer bid, Integer class_id,Integer number) {
        Date lend_date = new Date();
        Date back_date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(back_date);
        cal.add(Calendar.DATE, 30);
        back_date = cal.getTime();
        int check = lendMapper.check(bid,uid);
        if (number == 0) {
            return -1;
        }
        if (check == 0) {
            lendMapper.addLend(uid, bid, class_id, lend_date, back_date);
            lendMapper.updateBook(bid, number - 1);
            return 1;
        }else{
            return 2;
        }


    }


}
