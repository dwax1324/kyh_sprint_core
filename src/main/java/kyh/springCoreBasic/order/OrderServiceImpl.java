package kyh.springCoreBasic.order;

import kyh.springCoreBasic.discount.DiscountPolicy;
import kyh.springCoreBasic.discount.FixDiscountPolicy;
import kyh.springCoreBasic.member.Member;
import kyh.springCoreBasic.member.MemberRepository;
import kyh.springCoreBasic.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}