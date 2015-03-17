package dst.ass2.ejb.model.impl;

import dst.ass2.ejb.model.IAuditLog;
import dst.ass2.ejb.model.IAuditParameter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class AuditLog implements IAuditLog {

    @Id
    @GeneratedValue
    private Long id;

    private String method;
    private String result;
    private Date invocationTime;

    @OneToMany(targetEntity = AuditParameter.class)
    private List<IAuditParameter> auditParameters;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getResult() {
        return this.result;
    }

    @Override
    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public Date getInvocationTime() {
        return this.invocationTime;
    }

    @Override
    public void setInvocationTime(Date invocationTime) {
        this.invocationTime = invocationTime;
    }

    @Override
    public List<IAuditParameter> getParameters() {
        return this.auditParameters;
    }

    @Override
    public void setParameters(List<IAuditParameter> parameters) {
        this.auditParameters = parameters;
    }
}
