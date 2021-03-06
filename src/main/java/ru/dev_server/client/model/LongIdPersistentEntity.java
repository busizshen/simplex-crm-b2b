package ru.dev_server.client.model;

import net.sf.autodao.PersistentEntity;
import org.hibernate.Hibernate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**.*/
@MappedSuperclass
public class LongIdPersistentEntity implements PersistentEntity<Long> {
    @Override
    public Long getPrimaryKey() {
        return id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Override
    public int hashCode() {
        if(id==null){
            return 0;
        }else{
            return id.hashCode();
        }
    }


    @Override
    public boolean equals(Object obj) {

        if(obj instanceof LongIdPersistentEntity){
            LongIdPersistentEntity pe = (LongIdPersistentEntity) obj;
            if(id==null) {
                return false;
            }
            if (!Hibernate.getClass(this).equals(Hibernate.getClass(pe))) {
                return false;
            }

            return id.equals(pe.getId());

        }else{
            return false;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return getClass().getName()+"{id="+id+"}";
    }
}
