package dst.ass2.ejb.model.impl;

import dst.ass2.ejb.model.IAuditLog;
import dst.ass2.ejb.model.IAuditParameter;

import javax.persistence.*;

@Entity
public class AuditParameter implements IAuditParameter {

    @Id
    @GeneratedValue
    private Long id;

    private int parameterIndex;
    private String type;
    private String value;

    @ManyToOne(targetEntity = AuditLog.class)
    private IAuditLog auditLog;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Integer getParameterIndex() {
        return this.parameterIndex;
    }

    @Override
    public void setParameterIndex(Integer parameterIndex) {
        this.parameterIndex = parameterIndex;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getValue() {
        return this.value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public IAuditLog getAuditLog() {
        return this.auditLog;
    }

    @Override
    public void setAuditLog(IAuditLog auditLog) {
        this.auditLog = auditLog;
    }
}
