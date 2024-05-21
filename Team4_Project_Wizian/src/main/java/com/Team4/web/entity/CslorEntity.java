package com.Team4.web.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "COUNSELOR")
public class CslorEntity {
	
	@Id
	@Column(name = "USER_NO")
	private String userNo;

	@Column(name = "CAREER")
	private String career;
	
    @Column(name = "CSLOR_NM")
    private String cslorNm;
    
    @ManyToOne
    @JoinColumn(name = "C_CD")
    private DeptEntity department;
    
    @OneToOne
    @JoinColumn(name = "USER_NO")
    private UsersEntity users;
                
    @Column(name = "TEL_NO")
    private String telNo;
    
    @Column(name = "CSL_LOC")
    private String cslLoc;
    
    @Column(name = "NON_FACE")
    private String nonFace;
    
    @Column(name = "ONLINE")
    private int isOnlineAvailable;
    
    @Column(name = "CHAT")
    private String chat;
    
    @Column(name = "CSL_DETAIL")
    private String cslDetail;

}
