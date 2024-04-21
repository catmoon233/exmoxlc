package net.mcreator.exmoxl.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.exmoxl.init.ExmoxlModItems;
import net.mcreator.exmoxl.init.ExmoxlModAttributes;


import java.util.function.Supplier;
import java.util.UUID;
import java.util.Map;

public class ActivatiguiGaiGUIDaKaiShiMeiKeFaShengProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		ItemStack backup = ItemStack.EMPTY;
		double attackDamage = 0;
		double attdamagebase = 0;
		double changenum = 0;
		double mainhandnum = 0;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("xi1") == 1) {
			if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem())) {
				if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble("quality") > 0) {
					if (new Object() {
						public int getAmount(int sltid) {
							if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
								ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
								if (stack != null)
									return stack.getCount();
							}
							return 0;
						}
					}.getAmount(1) > 0) {
						if (!((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
								.getDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
										.getOrCreateTag().getDouble("zizhi")))) == 0)) {
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
											.getOrCreateTag().getDouble("zizhi"))))
									- new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(1) >= 0) {
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().putDouble(
										("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("zizhi"))),
										((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag().getDouble(
												("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
														.getOrCreateTag().getDouble("zizhi"))))
												- new Object() {
													public int getAmount(int sltid) {
														if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
															ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
															if (stack != null)
																return stack.getCount();
														}
														return 0;
													}
												}.getAmount(1)));
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(Blocks.AIR);
									_setstack.setCount(1);
									((Slot) _slots.get(1)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
							}
							if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
											.getOrCreateTag().getDouble("zizhi"))))
									- new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(1) < 0) {
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(ExmoxlModItems.MISCELLANEOUS_DUST.get());
									_setstack.setCount((int) (new Object() {
										public int getAmount(int sltid) {
											if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
												ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
												if (stack != null)
													return stack.getCount();
											}
											return 0;
										}
									}.getAmount(1) - (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
											.getOrCreateTag()
											.getDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
													.getOrCreateTag().getDouble("zizhi"))))));
									((Slot) _slots.get(1)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								(entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.putDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("zizhi"))), 0);
							}
						}
					}
					if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
							.getDouble(("zizhic" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble("zizhi")))) == 0) {
						if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(3)).getItem() : ItemStack.EMPTY).getItem() == Blocks.AIR.asItem()) {
							if (new Object() {
								public int getAmount(int sltid) {
									if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
										ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
										if (stack != null)
											return stack.getCount();
									}
									return 0;
								}
							}.getAmount(2) == (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
									.getDouble(("zizhix" + ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
											.getOrCreateTag().getDouble("zizhi"))))) {
								backup = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY);
								ItemStack heldItemStack = backup;
								Item heldItem = heldItemStack.getItem();
								attackDamage = heldItemStack.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE).stream().mapToDouble(attributeModifier -> attributeModifier.getAmount()).sum();
								changenum = 0.05 * Mth.nextDouble(RandomSource.create(), 1, new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2) * 5);
								mainhandnum = new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1);
								attdamagebase = 0.1 * Mth.nextDouble(RandomSource.create(), 1, new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(2) * 10) * new Object() {
									public int getAmount(int sltid) {
										if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
											ItemStack stack = ((Slot) _slots.get(sltid)).getItem();
											if (stack != null)
												return stack.getCount();
										}
										return 0;
									}
								}.getAmount(1) * 0.2 + attackDamage * 0.1;
								int ramdomattr = 0;
								int ramdomamount = RandomSource.create().nextInt(3) + 1;
								if (RandomSource.create().nextInt(2) == 0) {
									ChangeattrProcedure.addItemAttributeModifier2(backup, net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_DAMAGE,
											new AttributeModifier(UUID.fromString("164aba86-cce2-432a-b123-0669ce5ee6df"), "等级伤害加成", changenum * mainhandnum * 0.05 * attackDamage, AttributeModifier.Operation.ADDITION), EquipmentSlot.MAINHAND);
								}
								for (int i = 0; i < ramdomamount; i++) {
									ramdomattr = RandomSource.create().nextInt(8);
									switch (ramdomattr) {
										case 0 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, net.minecraft.world.entity.ai.attributes.Attributes.ATTACK_SPEED,
													(new AttributeModifier(UUID.fromString("04583f39-228b-471a-a0d7-288ecfe4a1f7"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.015), AttributeModifier.Operation.MULTIPLY_BASE)),
													EquipmentSlot.MAINHAND);
											break;
										case 1 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, net.minecraft.world.entity.ai.attributes.Attributes.MAX_HEALTH,
													(new AttributeModifier(UUID.fromString("6daba26a-4968-4149-881e-dd9527dde5d4"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.5), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 2 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, net.minecraft.world.entity.ai.attributes.Attributes.ARMOR,
													(new AttributeModifier(UUID.fromString("5928199a-de88-11ee-a005-325096b39f47"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.15), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 3 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, net.minecraft.world.entity.ai.attributes.Attributes.ARMOR_TOUGHNESS,
													(new AttributeModifier(UUID.fromString("59281c60-de88-11ee-9317-325096b39f47"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.15), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 4 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, ExmoxlModAttributes.CRIT.get(),
													(new AttributeModifier(UUID.fromString("59281c60-de88-11ee-9317-325096b39f47"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.5 * 0.5), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 5 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, ExmoxlModAttributes.CRITDAMAGE.get(),
													(new AttributeModifier(UUID.fromString("59281d78-de88-11ee-9021-325096b39f46"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.5 * 0.5), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 6 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, ExmoxlModAttributes.HITRATE.get(),
													(new AttributeModifier(UUID.fromString("59281e5e-de88-11ee-987d-325096b39f47"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.5), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
										case 7 :
											ChangeattrProcedure.addItemAttributeModifier2(backup, ExmoxlModAttributes.MIANSHAN.get(),
													(new AttributeModifier(UUID.fromString("59281c60-de88-11ee-9317-325096b39f47"), "\u5C5E\u6027\u589E\u5E45", (changenum * mainhandnum * 0.1 * 0.5), AttributeModifier.Operation.ADDITION)),
													EquipmentSlot.MAINHAND);
											break;
									}
								}
								backup.getOrCreateTag().putDouble("zizhi", (backup.getOrCreateTag().getDouble("zizhi") + 1));
								if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY).getOrCreateTag()
										.getDouble("zizhi") < (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof Supplier _splr && _splr.get() instanceof Map _slt ? ((Slot) _slt.get(4)).getItem() : ItemStack.EMPTY)
												.getOrCreateTag().getDouble("quality")) {
									backup.getOrCreateTag().putDouble(("zizhic" + backup.getOrCreateTag().getDouble("zizhi")),
											Math.round(Mth.nextDouble(RandomSource.create(), 1, 10) * backup.getOrCreateTag().getDouble("quality") * (backup.getOrCreateTag().getDouble("zizhi") + 1)));
									backup.getOrCreateTag().putDouble(("zizhix" + backup.getOrCreateTag().getDouble("zizhi")), (backup.getOrCreateTag().getDouble("quality")));
								} else {
									backup.getOrCreateTag().putDouble(("zizhic" + backup.getOrCreateTag().getDouble("zizhi")), (-1));
									backup.getOrCreateTag().putDouble(("zizhix" + backup.getOrCreateTag().getDouble("zizhi")), (-1));
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = backup;
									_setstack.setCount(1);
									((Slot) _slots.get(3)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(Blocks.AIR);
									_setstack.setCount(1);
									((Slot) _slots.get(2)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
								if (entity instanceof Player _player && _player.containerMenu instanceof Supplier _current && _current.get() instanceof Map _slots) {
									ItemStack _setstack = new ItemStack(Blocks.AIR);
									_setstack.setCount(1);
									((Slot) _slots.get(4)).set(_setstack);
									_player.containerMenu.broadcastChanges();
								}
							}
						}
					}
				}
			}
		}
	}
}
