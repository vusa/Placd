import com.placd.model.*;
import org.apache.shiro.crypto.hash.Sha1Hash

class BootStrap {

    def init = { servletContext ->
        new UserGroup(name:"Admin").save();
        new UserGroup(name:"Applicants").save();
        new UserGroup(name:"Recruiters").save();
        // new AppUser(name:"admin", email:"admin@placd", auth_type:"local", password:"admin", dob:new Date(), last_login:new Date(), group:new UserGroup(id:1), active:true).save();
        def user = new ShiroUser(username: "user123", passwordHash: new Sha1Hash("password").toHex());
        user.addToPermissions("*:*")
        user.save()
    }
    def destroy = {
    }
} 